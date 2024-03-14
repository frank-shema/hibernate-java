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

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			Properties settings = new Properties();
			//POSTGRESQL
			
			//settings.put(Environment.DRIVER, "org.postgresql.Driver");
			settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			//Postgresql
		//	settings.put(Environment.URL, "jdbc:postgresql://localhost:3306/myapp");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate");
			settings.put(Environment.USER, "frank");
			settings.put(Environment.PASS, "Shema0987!!!");
			//PostgreSQL
			//settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			settings.put(Environment.SHOW_SQL, true);
			settings.put(Environment.HBM2DDL_AUTO, "create-drop");
			configuration.setProperties(settings);
			configuration.addAnnotatedClass(Agents.class);
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Property.class);
     		configuration.addAnnotatedClass(Organisation.class);
			configuration.addAnnotatedClass(Account.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}

