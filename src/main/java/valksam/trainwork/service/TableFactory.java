package valksam.trainwork.service;


import valksam.trainwork.model.Table;
import valksam.trainwork.model.Table_1;
import valksam.trainwork.model.Table_2;
import valksam.trainwork.model.Tables;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Valk on 28.01.16.
 */
public class TableFactory {
    public static Table getEmptyConcreteTableInstance(String tableName) {
        try {
            Class clazz = Class.forName(Tables.valueOf(tableName).getClassName());
            List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
            switch (tableName.toUpperCase()){
                case "TABLE_1": {
                    return (Table_1) clazz.getConstructor().newInstance();
                }
                case "TABLE_2": {
                    return (Table_2) clazz.getConstructor().newInstance();
                }
            }
        } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
