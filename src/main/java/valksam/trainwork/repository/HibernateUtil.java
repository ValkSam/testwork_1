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

    private static void buildSessionFactory() {
        Configuration configuration = new Configuration().configure("/db/hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) buildSessionFactory();
        return sessionFactory;
    }

    public static void shutdown(){
        if (sessionFactory != null) getSessionFactory().close();
    }

}
