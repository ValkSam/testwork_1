package valksam.trainwork.service;


import valksam.trainwork.model.Table;
import valksam.trainwork.model.Tables;

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
            return (Table) clazz.getConstructor().newInstance();
        } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
