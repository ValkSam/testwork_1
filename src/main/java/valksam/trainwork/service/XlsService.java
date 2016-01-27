package valksam.trainwork.service;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import valksam.trainwork.controller.DataStorage;
import valksam.trainwork.model.Correspondence;
import valksam.trainwork.repository.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Valk on 25.01.16.
 */
public class XlsService {
    //используем мапу, на случай, если таблица  файле имею не ровную структуру.
    //Основной ориентир для выборки донных - номер столбца в заголовке
    public static Map<Integer, String> getColumnNames(File xlsFile) {
        Map<Integer, String> result = new HashMap<>();
        try (
                InputStream in = new FileInputStream(xlsFile);
                HSSFWorkbook wb = new HSSFWorkbook(in);
        ) {
            Row row = detectFirstRowWithData(wb);
            if (row == null) return result;

            for (Cell cell : row) {
                int cellType = cell.getCellType();
                if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                    switch (cellType) {
                        case Cell.CELL_TYPE_STRING:
                            if (!"".equals(cell.getStringCellValue())) {
                                result.put(cell.getColumnIndex(), cell.getStringCellValue());
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("заголовки полей должны иметь только текстовый формат ! " +
                                    "Лист: " + cell.getSheet().getSheetName() +
                                    " Строка: " + (cell.getRowIndex() + 1) +
                                    " Столбец: " + (cell.getColumnIndex() + 1));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean createDbTable(File xlsFile, String tableName, Map<Integer, String> columnMap) {
        File csvFile = XlsService.createCsv(xlsFile, columnMap);
        return csvFile != null && Repository.saveXlsData(tableName, csvFile);
    }

    public static String saveGSONSchema(String jsonFileName, String tableName, ObservableList<Correspondence> correspondencesTable) {
        String result = "";
        ObjectMapper objectMapper = new ObjectMapper(){{
            SimpleModule simpleModule = new SimpleModule();
            simpleModule.addSerializer(StringProperty.class, new JsonSerializer<StringProperty>() {
                @Override
                public void serialize(StringProperty stringProperty, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                      jsonGenerator.writeObject(stringProperty.get());
                }
            });
            registerModule(simpleModule);
        }};
        try(
                StringWriter sw = new StringWriter();
                )
        {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(sw, correspondencesTable);
            StringBuilder sb = new StringBuilder();
            sb.append("{\n\t\""+tableName.toUpperCase()+"\": ").append(sw.toString()).append("\n}");
            Path path = Paths.get(jsonFileName);
            Files.write(path,sb.toString().getBytes());
            result = path.toFile().getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    private static File createCsv(File xlsFile, Map<Integer, String> columnMap) {
        File result = null;
        try {
            result = File.createTempFile("tmp", ".csv");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        try (
                InputStream in = new FileInputStream(xlsFile);
                HSSFWorkbook wb = new HSSFWorkbook(in);
                BufferedWriter out = new BufferedWriter(new FileWriter(result));
        ) {
            Row row = detectFirstRowWithData(wb);

            if (row == null) {
                throw new RuntimeException("Не удается обработать файл. Возможно файл был изменен");
            }

            StringBuilder rowForWrite = new StringBuilder();
            for (Map.Entry<Integer, String> entry : columnMap.entrySet()) {
                if (!rowForWrite.toString().equals("")) {
                    rowForWrite.append(',');
                }
                String origFldName = entry.getValue();
                String newFldName = "";
                boolean f = false;
                for (Correspondence correspondence : DataStorage.correspondencesTable) {
                    if (correspondence.getColumnInFile().get().equals(origFldName)) {
                        newFldName = correspondence.getColumnInDataTable().get();
                        f = true;
                        break;
                    }
                }
                if (!f) {
                    throw new RuntimeException("Не удается обработать файл. Возможно файл был изменен");
                }
                rowForWrite.append('"').append(newFldName).append('"');
            }
            out.write(rowForWrite.toString());
            out.newLine();

            Sheet sheet = row.getSheet();
            Iterator<Row> iterator = sheet.iterator();
            for (iterator.next(); iterator.hasNext(); ) {
                rowForWrite = new StringBuilder();
                Row currentRow = iterator.next();
                boolean first = true;
                for (Map.Entry<Integer, String> entry : columnMap.entrySet()) {
                    if (!first) {
                        rowForWrite.append(',');
                    }
                    first = false;
                    Cell cell = currentRow.getCell(entry.getKey());
                    if (cell == null) {
                        rowForWrite.append("");
                        continue;
                    }
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING: {
                            rowForWrite.append('"').append(cell.getStringCellValue()).append('"');
                            break;
                        }
                        case Cell.CELL_TYPE_NUMERIC: {
                            rowForWrite.append(cell.getNumericCellValue());
                            break;
                        }
                        case Cell.CELL_TYPE_BOOLEAN: {
                            rowForWrite.append('"').append(cell.getBooleanCellValue()).append('"');
                            break;
                        }
                    }
                }
                out.write(rowForWrite.toString());
                out.newLine();
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            result = null;
        }
        return result;
    }

    private static Row detectFirstRowWithData(HSSFWorkbook wb) {
        Row row = null;
        for (Iterator<Sheet> iterator = wb.iterator(); iterator.hasNext() && row == null; ) {
            Sheet sheet = iterator.next();
            for (Row r : sheet) {
                if (r.getFirstCellNum() != -1) {
                    row = r;
                    break;
                }
            }
        }
        return row;
    }

}
