package valksam.trainwork.service;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Valk on 25.01.16.
 */
public class XlsService {
    //use the map to store the column numbers in case of rest rows will contain data in wrong columns
    public static Map<Integer, String> getColumnNames(String name) {
        Map<Integer, String> result = new HashMap<>();
        try (
                InputStream in = new FileInputStream(name);
                HSSFWorkbook wb = new HSSFWorkbook(in);
        ) {
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

}
