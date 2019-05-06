package za.co.tswalano.obites.Modals;

import javax.persistence.*;
@Entity
public class Customers {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column
    private String FirstName;

    @Column
    private String LastName;

    @Column
    private String Username;

    @Column
    private String EmailAddress;

    @Column
    private String PhoneNumber;

    @Column
    private String Password;

    public Customers() {
    }

    public Customers(String username, String password) {
        Username = username;
        Password = password;
    }

    public Customers(String firstName, String lastName, String username, String emailAddress, String phoneNumber, String password) {
        FirstName = firstName;
        LastName = lastName;
        Username = username;
        EmailAddress = emailAddress;
        PhoneNumber = phoneNumber;
        Password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

