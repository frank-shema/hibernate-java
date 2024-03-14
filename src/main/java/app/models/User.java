package app.models;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    
    @OneToMany(mappedBy = "user")
    private List<Account> account;

    @OneToMany(mappedBy = "user")
    private List<Property> property;

    public User(String name, String email, String address, String phoneNumber) {
        super();
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Account> getProperty() {
        return account;
    }

    public void setProperty(List<Account> account) {
        this.account = account;
    }

    public User() {
        super();
    }
}