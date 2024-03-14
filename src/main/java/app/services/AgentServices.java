package app.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import app.models.Agents;
import app.utils.HibernateUtil;

public class AgentServices {
    protected static SessionFactory sf = HibernateUtil.getSessionFactory();
    protected static Session session;

    public static AgentServices AgentServices;

    // Singleton pattern to get an instance of AgentServices
    public static AgentServices getInstance() {
        if (AgentServices == null) {
            return new AgentServices();
        }
        return null;
    }

    // Private constructor to restrict instantiation from outside the class
    private AgentServices() {
    }

    // Method to add a new agent to the database
    public void addagent(Agents agent) {
        session = sf.openSession();
        // Begin a transaction
        session.beginTransaction();
        // Save the agent object to the database
        session.save(agent);
        // Commit the transaction
        session.getTransaction().commit();
    }

    // Method to retrieve an agent by its ID
    public Agents getAgentById(int agentId) {
        session = sf.openSession();
        // Retrieve the agent object by ID
        Agents agent = session.get(Agents.class, agentId);
        session.close(); // Close the session after use
        return agent;
    }
}