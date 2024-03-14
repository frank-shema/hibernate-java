package app.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import app.models.User;
import app.utils.HibernateUtil;

public class UserServices {
	protected static SessionFactory sf=HibernateUtil.getSessionFactory();
	protected static Session session;
	public static UserServices UserServices;
	public static UserServices getInstance() {

		if (UserServices == null)
			return new UserServices();

		return null;
	}
	private UserServices() {
	}
	public void adduser(User user) {
	    session = sf.openSession();
		//session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

	}
	public User getUserById(int userId) {
        session = sf.openSession();
        User user = session.get(User.class, userId);
        session.close(); 
        return user;
    }

}
