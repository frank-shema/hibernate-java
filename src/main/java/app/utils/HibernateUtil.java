package app.utils;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import app.models.Account;
import app.models.Agents;
import app.models.Organisation;
import app.models.Property;
import app.models.User;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    // Method to get the Hibernate SessionFactory
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();

            // Database connection settings
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate");
            settings.put(Environment.USER, "frank");
            settings.put(Environment.PASS, "Shema0987!!!");

            // Hibernate dialect for MySQL
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

            // Show SQL statements
            settings.put(Environment.SHOW_SQL, true);

            // Automatically create and drop tables
            settings.put(Environment.HBM2DDL_AUTO, "create-drop");

            configuration.setProperties(settings);

            // Add annotated classes
            configuration.addAnnotatedClass(Agents.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Property.class);
            configuration.addAnnotatedClass(Organisation.class);
            configuration.addAnnotatedClass(Account.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // Build the SessionFactory
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}