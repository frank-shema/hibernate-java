package app.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import app.models.Property;
import app.utils.HibernateUtil;


public class PropertyServices {
	protected static SessionFactory sf=HibernateUtil.getSessionFactory();
	protected static Session session;
	public static PropertyServices PropertyServices;
	public static PropertyServices getInstance() {

		if (PropertyServices == null)
			return new PropertyServices();

		return null;
	}
	private PropertyServices() {
	}
	public void addProperty(Property agent) {
	    session = sf.openSession();
		//session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(agent);
		session.getTransaction().commit();

	}
	public  Property getPropertyById(int id) {
		session=sf.openSession();
		Property property=session.get(Property.class, id);
		session.close();
		return property;
	}

}
