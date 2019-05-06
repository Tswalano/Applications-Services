package za.co.tswalano.userportal.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "StudentCourseMarks")
public class StudentCourseMarks {

//    CONSTRAINT SchoolCourseMarks_SchoolSubjects_FK FOREIGN KEY (SchoolSubject_id) REFERENCES SchoolSubjects (ID),
//    CONSTRAINT SchoolCourseMarks_Students_FK FOREIGN KEY (student_id) REFERENCES Students (ID)

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StudentCMrk_ID;

    @Column
    private String Term;

    @Column
    private String Remarks;

    @Column
    private String Year;

    @Column
    private int OverrallMarks;

    @Column
    private int TotalMark;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;

    @ManyToOne
    private SchoolCourse schoolCourse;

    @ManyToOne
    private StudentMast studentMast;

    public StudentCourseMarks() {
    }

    public StudentCourseMarks(String term, String remarks, String year, int overrallMarks, int totalMark, SchoolCourse schoolCourse, StudentMast studentMast) {
        Term = term;
        Remarks = remarks;
        Year = year;
        OverrallMarks = overrallMarks;
        TotalMark = totalMark;
        this.schoolCourse = schoolCourse;
        this.studentMast = studentMast;
    }

    public int getStudentCMrk_ID() {
        return StudentCMrk_ID;
    }

    public void setStudentCMrk_ID(int studentCMrk_ID) {
        StudentCMrk_ID = studentCMrk_ID;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public int getOverrallMarks() {
        return OverrallMarks;
    }

    public void setOverrallMarks(int overrallMarks) {
        OverrallMarks = overrallMarks;
    }

    public int getTotalMark() {
        return TotalMark;
    }

    public void setTotalMark(int totalMark) {
        TotalMark = totalMark;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public SchoolCourse getSchoolCourse() {
        return schoolCourse;
    }

    public void setSchoolCourse(SchoolCourse schoolCourse) {
        this.schoolCourse = schoolCourse;
    }

    public StudentMast getStudentMast() {
        return studentMast;
    }

    public void setStudentMast(StudentMast studentMast) {
        this.studentMast = studentMast;
    }
}
