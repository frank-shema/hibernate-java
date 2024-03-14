package app.utils;

import app.services.UserServices;
import app.services.PropertyServices;
import app.services.AgentServices;
import app.services.OrganisationServices;
import app.models.Account;
import app.models.Agents;
import app.models.Organisation;
import app.models.Property;
import app.models.User;
import app.services.AccountServices;

public class Program {
    public static void main(String args[]) {
        PropertyServices propertyService = PropertyServices.getInstance();
        UserServices userService = UserServices.getInstance();
        AgentServices agentService = AgentServices.getInstance();
        OrganisationServices organisationService = OrganisationServices.getInstance();
        AccountServices accountServices = AccountServices.getInstance();

        Organisation org = new Organisation("Estate", "estate@estate.com", "Kigali, Rwanda", "E state is an organisation which has the apartment for rent");
        organisationService.addorganisation(org);
        Organisation org1 = organisationService.getOrganisationById(1);

        Agents agent = new Agents("shema", "frank", "+2507535848", "Nyabihu");
        agentService.addagent(agent);
        Agents agent1 = agentService.getAgentById(1);

        User user = new User("shema", "frank@gmail.com", "Nyabihu", "+250787474");
        userService.adduser(user);
        User user1 = userService.getUserById(1);

        Property property = new Property("Kigali Apartment", "Kigali Apartment is an apartment located in Gasabo district known for its good service", "Gasabo", 300, agent1, user1);
        propertyService.addProperty(property);

        Account account1 = new Account("Organisation", "446383769383", 70000, user1);
        accountServices.addaccount(account1);
    }
}