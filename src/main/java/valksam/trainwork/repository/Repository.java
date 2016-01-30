package valksam.trainwork.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import valksam.trainwork.model.Table;

/**
 * Created by Valk on 26.01.16.
 */
public class Repository {

    public static boolean save(Table table) {
        boolean result = false;
        Session session = null;
        try {
            {
                session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();

                session.save(table);

                transaction.commit();
            }
            //
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return result;
    }

    public static boolean clear(String tableName) {
        boolean result = false;
        Session session = null;
        try {
            {
                session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();

                session.createSQLQuery("DELETE FROM " + tableName).executeUpdate();

                transaction.commit();
            }
            //
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return result;
    }
}
