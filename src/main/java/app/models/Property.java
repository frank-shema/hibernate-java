package app.models;

import jakarta.persistence.*;

@Entity
public class Property {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private String location;
    private int price;
    
    @ManyToOne
    private Agents agent;
    
    @ManyToOne
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Agents getAgent() {
        return agent;
    }

    public void setAgent(Agents agent) {
        this.agent = agent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Property(String name, String description, String location, int price, Agents agent) {
        super();
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
        this.agent = agent;
    }

    public Property(String name, String description, String location, int price, Agents agent, User user) {
        super();
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
        this.agent = agent;
        this.user = user;
    }

    public Property() {
        super();
    }

    public Property(String name, String description, String location, int price) {
        super();
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
    }
}