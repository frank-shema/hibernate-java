package app.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import app.models.Organisation;
import app.utils.HibernateUtil;

public class OrganisationServices {
	protected static SessionFactory sf=HibernateUtil.getSessionFactory();
	protected static Session session;
	public static OrganisationServices OrganisationServices;
	public static OrganisationServices getInstance() {

		if (OrganisationServices == null)
			return new OrganisationServices();

		return null;
	}
	private OrganisationServices() {
	}
	public void addorganisation(Organisation organisation) {
	    session = sf.openSession();
		//session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(organisation);
		session.getTransaction().commit();

	}
	public Organisation getOrganisationById(int OrganisationId) {
        session = sf.openSession();
        Organisation organisation = session.get(Organisation.class, OrganisationId);
        session.close(); // Close the session after use
        return organisation;
    }

}
