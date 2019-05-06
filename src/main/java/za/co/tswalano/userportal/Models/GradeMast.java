package za.co.tswalano.userportal.Models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "GradeMast")
public class GradeMast {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Grade_ID;

    @Column
    private String GradeCode;

    @Column
    private int Grade;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;

    public GradeMast() {
    }

    public GradeMast(String gradeCode, int grade) {
        GradeCode = gradeCode;
        Grade = grade;
    }

    public int getGrade_ID() {
        return Grade_ID;
    }

    public void setGrade_ID(int grade_ID) {
        Grade_ID = grade_ID;
    }

    public String getGradeCode() {
        return GradeCode;
    }

    public void setGradeCode(String gradeCode) {
        GradeCode = gradeCode;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }
}
