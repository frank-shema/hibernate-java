package app.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import app.models.Account;
import app.utils.HibernateUtil;

public class AccountServices {
	protected static SessionFactory sf=HibernateUtil.getSessionFactory();
	protected static Session session;
	public static AccountServices AccountServices;
	public static AccountServices getInstance() {

		if (AccountServices == null)
			return new AccountServices();

		return null;
	}	
	private AccountServices() {
	}
	public void addaccount(Account account) {
	    session = sf.openSession();
		//session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();

	}

	public Account getAccountById(int accountId) {
        session = sf.openSession();
        Account account = session.get(Account.class, accountId);
        session.close(); // Close the session after use
        return account;
    }
}
