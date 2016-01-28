package valksam.trainwork.service;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import javafx.collections.ObservableList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.hibernate.TypeMismatchException;
import valksam.trainwork.controller.DataStorage;
import valksam.trainwork.dto.MappingInfoItem;
import valksam.trainwork.dto.TableMapInfo;
import valksam.trainwork.model.Correspondence;
import valksam.trainwork.model.Table;
import valksam.trainwork.model.Tables;
import valksam.trainwork.repository.Repository;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

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

    public static List<String> getTablesList() {
        return Arrays.asList(Tables.values())
                .stream()
                .map(Enum::toString)
                .collect(Collectors.toList());
    }

    private static Boolean saveXlsToDb(File xlsFile, Map<Integer, String> columnMap, Table table, String tableName) {
        Boolean result = false;
        try (
                InputStream in = new FileInputStream(xlsFile);
                HSSFWorkbook wb = new HSSFWorkbook(in);
        ) {
            Row row = detectFirstRowWithData(wb);

            if (row == null) {
                throw new RuntimeException("Не удается обработать файл. Возможно файл был изменен");
            }

            //список полей Таблицы в том поорядке как они в xls
            Map<String, String> xlsToTableMap = new HashMap<>();

            for (Map.Entry<Integer, String> entry : columnMap.entrySet()) {
                String origFldName = entry.getValue();
                String tableFldName = "";
                boolean f = false;
                for (Correspondence correspondence : DataStorage.correspondencesTable) {
                    if (correspondence.getColumnInFile().get().equals(origFldName)) {
                        tableFldName = correspondence.getColumnInDataTable().get();
                        f = true;
                        break;
                    }
                }
                if (!f) {
                    throw new RuntimeException("Не удается обработать файл. Возможно файл был изменен");
                }
                xlsToTableMap.put(origFldName, tableFldName);
            }

            Sheet sheet = row.getSheet();
            Iterator<Row> iterator = sheet.iterator();
            for (iterator.next(); iterator.hasNext(); ) {
                Row currentRow = iterator.next();
                for (Map.Entry<Integer, String> entry : columnMap.entrySet()) {
                    Cell cell = currentRow.getCell(entry.getKey());
                    Field field = table.getClass().getDeclaredField(xlsToTableMap.get(entry.getValue()));
                    field.setAccessible(true);
                    if (cell == null || "".equals(cell.toString())) {
                        field.set(table, null);
                        continue;
                    }
                    switch (field.getType().getName()) {
                        case "java.lang.String": {
                            field.set(table, cell.toString());
                            break;
                        }
                        case "java.lang.Integer": {
                            field.set(table, Double.valueOf(cell.toString()).intValue());
                            break;
                        }
                        default: {
                            throw new TypeMismatchException("Данные в таблице не соответсвуют типу поля: " +
                                    "Лист: " + cell.getSheet().getSheetName() +
                                    " Строка: " + (cell.getRowIndex() + 1) +
                                    " Столбец: " + (cell.getColumnIndex() + 1));
                        }
                    }
                }
                if (! Repository.save(table)) return false;
            }
            result = true;
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static boolean createDbTable(File xlsFile, String tableName, Map<Integer, String> columnMap) {
        Table table = TableFactory.getEmptyConcreteTableInstance(tableName);
        return saveXlsToDb(xlsFile, columnMap, table, tableName);
    }

    public static String saveGSONSchema(String xlsFileName, String jsonFileName, String tableName, ObservableList<Correspondence> correspondencesTable) {
        String result = "";
        ObjectMapper objectMapper = new ObjectMapper() {{
            SimpleModule simpleModule = new SimpleModule();
            simpleModule.addSerializer(Correspondence.class, new JsonSerializer<Correspondence>() {
                @Override
                public void serialize(Correspondence correspondence, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                    if (!"".equals(correspondence.getColumnInDataTable().get())) {
                        jsonGenerator.writeObject(
                                new MappingInfoItem(correspondence.getColumnInFile().get(),
                                        correspondence.getColumnInDataTable().get()));
                    }
                }
            });
            registerModule(simpleModule);
        }};
        try (
                StringWriter sw = new StringWriter();
        ) {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(sw, new TableMapInfo(xlsFileName, tableName.toUpperCase(), correspondencesTable));
            //
            StringBuilder sb = new StringBuilder();
            sb.append(sw.toString());
            Path path = Paths.get(jsonFileName);
            Files.write(path, sb.toString().getBytes());
            result = path.toFile().getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
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
