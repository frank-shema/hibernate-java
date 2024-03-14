package app.models;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Agents {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String phoneNUmber;
    private String address;
    
    @ManyToOne
    private Organisation organisation;
    
    @OneToMany(mappedBy = "agent")
    private List<Property> property;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(String phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Agents(String name, String email, String phoneNUmber, String address, Organisation organisation) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNUmber = phoneNUmber;
        this.address = address;
//        this.organisation = organisation;
    }

    public Agents(String name, String email, String phoneNUmber, String address) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNUmber = phoneNUmber;
        this.address = address;
    }

    public List<Property> getProperty() {
        return property;
    }

    public void setProperty(List<Property> property) {
        this.property = property;
    }

    public Agents() {
        super();
    }
}