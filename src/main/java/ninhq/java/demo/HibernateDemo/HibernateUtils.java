package ninhq.java.demo.HibernateDemo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if (sessionFactory==null){
            Configuration cfg = new Configuration();
            Properties setting = new Properties();

            setting.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            setting.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/quizappdb");
            setting.setProperty(Environment.USER, "root");
            setting.setProperty(Environment.PASS, "nmastera2000");
            setting.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

            setting.put(Environment.SHOW_SQL, "true");
            setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            setting.put(Environment.HBM2DDL_AUTO, "none");

            cfg.setProperties(setting);
            cfg.addAnnotatedClass(QuestionEntity.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties()).build();

            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
            System.out.println("Hibernate sessionFactory was created completely");
        }
        return sessionFactory;
    }
}
