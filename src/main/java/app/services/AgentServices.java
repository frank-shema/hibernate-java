package app.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import app.models.Agents;
import app.utils.HibernateUtil;

public class AgentServices {
	protected static SessionFactory sf=HibernateUtil.getSessionFactory();
	protected static Session session;
	public static AgentServices AgentServices;
	public static AgentServices getInstance() {

		if (AgentServices == null)
			return new AgentServices();

		return null;
	}
	private AgentServices() {
	}
	public void addagent(Agents agent) {
	    session = sf.openSession();
		//session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(agent);
		session.getTransaction().commit();

	}
	public Agents getAgentById(int agentId) {
        session = sf.openSession();
        Agents agent = session.get(Agents.class, agentId);
        session.close(); // Close the session after use
        return agent;
    }

}
