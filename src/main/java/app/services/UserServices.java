package app.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import app.models.User;
import app.utils.HibernateUtil;

public class UserServices {
    protected static SessionFactory sf = HibernateUtil.getSessionFactory();
    protected static Session session;

    public static UserServices UserServices;
    
    // Singleton pattern to get an instance of UserServices
    public static UserServices getInstance() {
        if (UserServices == null) {
            return new UserServices();
        }
        return null;
    }

    // Private constructor to restrict instantiation from outside the class
    private UserServices() {
    }

    // Method to add a new user to the database
    public void adduser(User user) {
        session = sf.openSession();
        // Begin a transaction
        session.beginTransaction();
        // Save the user object to the database
        session.save(user);
        // Commit the transaction
        session.getTransaction().commit();
    }

    // Method to retrieve a user by their ID
    public User getUserById(int userId) {
        session = sf.openSession();
        // Retrieve the user object by ID
        User user = session.get(User.class, userId);
        session.close(); // Close the session to release resources
        return user;
    }
}