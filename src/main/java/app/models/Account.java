package app.models;
import jakarta.persistence.*;

@Entity

public class Account {
@Id
@GeneratedValue
int id;
private String type;
private String accountNumber;
private int amount;
@ManyToOne
private User user;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Account(String type, String accountNumber, int amount, User user) {
	super();
	this.type = type;
	this.accountNumber = accountNumber;
	this.amount = amount;
	this.user = user;
}
public Account() {
	super();
}
}
