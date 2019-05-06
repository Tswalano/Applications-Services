package za.co.tswalano.userportal.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "SchoolSubjects")
public class SchoolSubjects {

//    CONSTRAINT SchoolCourseMarks_SchoolGrade_FK FOREIGN KEY (grade_id) REFERENCES SchoolGrades (ID),
//    CONSTRAINT SchoolCourseSubjects_FK FOREIGN KEY (Course_id) REFERENCES SchoolCourse (ID),
//    CONSTRAINT SubjectMastSubjects_FK FOREIGN KEY (Subject_id) REFERENCES SubjectMast (ID)

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SchoolSub_ID;

    @Column
    private String SubjectType;

    @Column
    private String SubjectTypeCode;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;

    @ManyToOne
    private SchoolGrades schoolGrades;

    @ManyToOne
    private SubjectMast subjectMast;

    public SchoolSubjects() {
    }

    public SchoolSubjects(String subjectType, String subjectTypeCode, SchoolGrades schoolGrades, SubjectMast subjectMast) {
        SubjectType = subjectType;
        SubjectTypeCode = subjectTypeCode;
        this.schoolGrades = schoolGrades;
        this.subjectMast = subjectMast;
    }

    public int getSchoolSub_ID() {
        return SchoolSub_ID;
    }

    public void setSchoolSub_ID(int schoolSub_ID) {
        SchoolSub_ID = schoolSub_ID;
    }

    public String getSubjectType() {
        return SubjectType;
    }

    public void setSubjectType(String subjectType) {
        SubjectType = subjectType;
    }

    public String getSubjectTypeCode() {
        return SubjectTypeCode;
    }

    public void setSubjectTypeCode(String subjectTypeCode) {
        SubjectTypeCode = subjectTypeCode;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public SchoolGrades getSchoolGrades() {
        return schoolGrades;
    }

    public void setSchoolGrades(SchoolGrades schoolGrades) {
        this.schoolGrades = schoolGrades;
    }

    public SubjectMast getSubjectMast() {
        return subjectMast;
    }

    public void setSubjectMast(SubjectMast subjectMast) {
        this.subjectMast = subjectMast;
    }
}
