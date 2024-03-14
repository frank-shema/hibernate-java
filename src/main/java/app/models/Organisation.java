package app.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

@Entity

public class Organisation {
@Id
@GeneratedValue
int id;
private String name;
private String email;
private String address;
private String description;
@OneToMany(mappedBy="organisation")
private List <Agents> agents;
public int getId() {
	return id;
}
public void setId(int id) {//@OneToMany(mappedBy="organisation")
	//private List <Agents> agents;
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}


public Organisation(String name, String email, String address, String description, List<Agents> agents) {
	super();
	this.name = name;
	this.email = email;
	this.address = address;
	this.description = description;
	this.agents = agents;
}
public Organisation() {
	super();
}
public Organisation( String name, String email, String address, String description) {
	super();
	
	this.name = name;
	this.email = email;
	this.address = address;
	this.description = description;
}
}
