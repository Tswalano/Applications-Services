package za.co.tswalano.userportal.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.swing.text.html.HTML;
import java.util.*;

@Entity
//@Table(name = "SchoolMast")
public class SchoolMast {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int School_ID;

    @Column
    private String SchoolName;

    @Column
    private String Circuit;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;

    public SchoolMast() {
    }

    public SchoolMast(String schoolName, String circuit) {
        SchoolName = schoolName;
        Circuit = circuit;
    }

    public int getSchool_ID() {
        return School_ID;
    }

    public void setSchool_ID(int school_ID) {
        School_ID = school_ID;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getCircuit() {
        return Circuit;
    }

    public void setCircuit(String circuit) {
        Circuit = circuit;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }
}
