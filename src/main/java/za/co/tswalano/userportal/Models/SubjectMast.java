package za.co.tswalano.userportal.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "SubjectMast")
public class SubjectMast {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Subject_ID;

    @Column
    private String SubjectCode;

    @Column
    private String SubjectName;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;

    public SubjectMast() {
    }

    public SubjectMast(String subjectCode, String subjectName) {
        SubjectCode = subjectCode;
        SubjectName = subjectName;
    }

    public int getSubject_ID() {
        return Subject_ID;
    }

    public void setSubject_ID(int subject_ID) {
        Subject_ID = subject_ID;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        SubjectCode = subjectCode;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }
}
