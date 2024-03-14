package app.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import app.models.Account;
import app.utils.HibernateUtil;

public class AccountServices {
    protected static SessionFactory sf = HibernateUtil.getSessionFactory();
    protected static Session session;

    public static AccountServices AccountServices;

    // Singleton pattern to get an instance of AccountServices
    public static AccountServices getInstance() {
        if (AccountServices == null) {
            return new AccountServices();
        }
        return null;
    }

    // Private constructor to restrict instantiation from outside the class
    private AccountServices() {
    }

    // Method to add a new account to the database
    public void addaccount(Account account) {
        session = sf.openSession();
        // Begin a transaction
        session.beginTransaction();
        // Save the account object to the database
        session.save(account);
        // Commit the transaction
        session.getTransaction().commit();
    }

    // Method to retrieve an account by its ID
    public Account getAccountById(int accountId) {
        session = sf.openSession();
        // Retrieve the account object by ID
        Account account = session.get(Account.class, accountId);
        session.close(); // Close the session after use
        return account;
    }
}