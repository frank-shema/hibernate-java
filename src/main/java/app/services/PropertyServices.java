package app.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import app.models.Property;
import app.utils.HibernateUtil;

public class PropertyServices {
    protected static SessionFactory sf = HibernateUtil.getSessionFactory();
    protected static Session session;

    public static PropertyServices PropertyServices;

    // Singleton pattern to get an instance of PropertyServices
    public static PropertyServices getInstance() {
        if (PropertyServices == null) {
            return new PropertyServices();
        }
        return null;
    }

    // Private constructor to restrict instantiation from outside the class
    private PropertyServices() {
    }

    // Method to add a new property to the database
    public void addProperty(Property property) {
        session = sf.openSession();
        // Begin a transaction
        session.beginTransaction();
        // Save the property object to the database
        session.save(property);
        // Commit the transaction
        session.getTransaction().commit();
    }

    // Method to retrieve a property by its ID
    public Property getPropertyById(int id) {
        session = sf.openSession();
        // Retrieve the property object by ID
        Property property = session.get(Property.class, id);
        session.close(); // Close the session to release resources
        return property;
    }
}