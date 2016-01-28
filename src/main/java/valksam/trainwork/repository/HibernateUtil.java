package valksam.trainwork.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import valksam.trainwork.model.Table_1;
import valksam.trainwork.model.Table_2;

/**
 * Created by Valk on 26.01.16.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure("/db/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }

}
