package za.co.tswalano.userportal.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "StudentMast")
public class StudentMast {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Student_ID;

    @Column
    private String FirstName;

    @Column
    private String LastName;

    @Column
    private Date DateOfBirth;

    @Column
    private String EmailAddress;

    @Column
    private String PhoneNumber;

    @Column
    private String Gender;

    @Column
    private String IdNumber;

    @Column
    private String Password;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;

    public StudentMast() {
    }

    public StudentMast(int Student_ID) {
        this.Student_ID = Student_ID;
    }

    public StudentMast(String firstName, String lastName, Date dateOfBirth, String emailAddress, String phoneNumber, String gender, String idNumber, String password) {
        FirstName = firstName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        EmailAddress = emailAddress;
        PhoneNumber = phoneNumber;
        Gender = gender;
        IdNumber = idNumber;
        Password = password;
    }

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int student_ID) {
        Student_ID = student_ID;
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

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
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

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(String idNumber) {
        IdNumber = idNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }
}
