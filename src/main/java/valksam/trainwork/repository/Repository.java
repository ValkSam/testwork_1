package valksam.trainwork.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.File;

/**
 * Created by Valk on 26.01.16.
 */
public class Repository {
    public static boolean saveXlsData(String tableName, File csvFile) {
        boolean result = false;
        Session session = null;
        tableName = tableName.toUpperCase();
        try {
            {
                session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();
                String sql = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME LIKE '" + tableName + "' ";
                Query query = session.createSQLQuery(sql);
                //
                /*вариант - всегда убиваем таблицу
                * так проще соблюсти порядок полей для разных сохранений*/
                if (query.list().size() != 0) {
                    sql = "DROP TABLE " + tableName;
                    query = session.createSQLQuery(sql);
                    query.executeUpdate();
                }
                sql = "CREATE TABLE " + tableName + " AS SELECT * FROM CSVREAD ('" + csvFile.getAbsolutePath() + "')";


                /*вариант, не убивать таблицу, а просто чистить
                if (query.list().size() == 0) {
                    sql = "CREATE TABLE " + tableName + " AS SELECT * FROM CSVREAD ('" + csvFile.getAbsolutePath() + "')";
                } else {
                    sql = "DELETE "+tableName;
                    query = session.createSQLQuery(sql);
                    query.executeUpdate();
                    sql = "INSERT INTO "+tableName+" SELECT * FROM CSVREAD ('" + csvFile.getAbsolutePath() + "')";
                }
                */

                query = session.createSQLQuery(sql);
                query.executeUpdate();
                transaction.commit();
            }
            //
            result = true;
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return result;
    }
}
