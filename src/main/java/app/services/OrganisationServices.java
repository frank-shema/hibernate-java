package app.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import app.models.Organisation;
import app.utils.HibernateUtil;

public class OrganisationServices {
    protected static SessionFactory sf = HibernateUtil.getSessionFactory();
    protected static Session session;

    public static OrganisationServices OrganisationServices;

    // Singleton pattern to get an instance of OrganisationServices
    public static OrganisationServices getInstance() {
        if (OrganisationServices == null) {
            return new OrganisationServices();
        }
        return null;
    }

    // Private constructor to restrict instantiation from outside the class
    private OrganisationServices() {
    }

    // Method to add a new organisation to the database
    public void addorganisation(Organisation organisation) {
        session = sf.openSession();
        // Begin a transaction
        session.beginTransaction();
        // Save the organisation object to the database
        session.save(organisation);
        // Commit the transaction
        session.getTransaction().commit();
    }

    // Method to retrieve an organisation by its ID
    public Organisation getOrganisationById(int OrganisationId) {
        session = sf.openSession();
        // Retrieve the organisation object by ID
        Organisation organisation = session.get(Organisation.class, OrganisationId);
        session.close(); // Close the session after use
        return organisation;
    }
}