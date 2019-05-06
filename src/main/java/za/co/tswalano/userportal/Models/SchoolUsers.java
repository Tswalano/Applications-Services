package za.co.tswalano.userportal.Models;

import javax.persistence.*;

@Entity
public class SchoolUsers {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SchoolUser_ID;

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

    @ManyToOne
    SchoolMast schoolMast;

    public SchoolUsers() {
    }

    public SchoolUsers(String username, String password) {
        this.Username = username;
        this.Password = password;
    }

    public SchoolUsers(String firstName, String lastName, String username, String emailAddress, String phoneNumber, String password, SchoolMast schoolMast) {
        FirstName = firstName;
        LastName = lastName;
        Username = username;
        EmailAddress = emailAddress;
        PhoneNumber = phoneNumber;
        Password = password;
        this.schoolMast = schoolMast;
    }

    public int getSchoolUser_ID() {
        return SchoolUser_ID;
    }

    public void setSchoolUser_ID(int schoolUser_ID) {
        SchoolUser_ID = schoolUser_ID;
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

    public SchoolMast getSchoolMast() {
        return schoolMast;
    }

    public void setSchoolMast(SchoolMast schoolMast) {
        this.schoolMast = schoolMast;
    }
}
