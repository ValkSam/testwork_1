package valksam.trainwork.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Valk on 26.01.16.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory = new Configuration().configure("/db/hibernate.cfg.xml")
                .buildSessionFactory();
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
