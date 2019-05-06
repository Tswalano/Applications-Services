package za.co.tswalano.userportal.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "SchoolGrades")
public class SchoolGrades {

//    CONSTRAINT SchoolGradeMast_FK FOREIGN KEY (grade_id) REFERENCES GradeMast (ID)

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SchoolGrd_ID;

    @Column
    private String ClassCode;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;

    @ManyToOne
    private GradeMast gradeMast;

    public SchoolGrades() {
    }

    public SchoolGrades(String classCode, GradeMast gradeMastId) {
        ClassCode = classCode;
        gradeMast = gradeMastId;
    }

    public int getSchoolGrd_ID() {
        return SchoolGrd_ID;
    }

    public void setSchoolGrd_ID(int schoolGrd_ID) {
        SchoolGrd_ID = schoolGrd_ID;
    }

    public String getClassCode() {
        return ClassCode;
    }

    public void setClassCode(String classCode) {
        ClassCode = classCode;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public GradeMast getGradeMast() {
        return gradeMast;
    }

    public void setGradeMast(GradeMast gradeMast) {
        this.gradeMast = gradeMast;
    }
}
