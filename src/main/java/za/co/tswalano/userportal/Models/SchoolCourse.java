package za.co.tswalano.userportal.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "SchoolCourse")
public class SchoolCourse {

//    CONSTRAINT SchoolCourseSchool_FK FOREIGN KEY (SchoolCourse_id) REFERENCES SchoolMast (ID)

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Course_ID;

    @Column
    private String CourseName;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;

    @ManyToOne
    private SchoolMast schoolMast;

    @ManyToOne
    private SchoolSubjects schoolSubjects;

    public SchoolCourse() {
    }

    public SchoolCourse(String courseName, SchoolMast schoolMast, SchoolSubjects schoolSubjects) {
        CourseName = courseName;
        this.schoolMast = schoolMast;
        this.schoolSubjects = schoolSubjects;
    }

    public int getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(int course_ID) {
        Course_ID = course_ID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public SchoolMast getSchoolMast() {
        return schoolMast;
    }

    public void setSchoolMast(SchoolMast schoolMast) {
        this.schoolMast = schoolMast;
    }

    public SchoolSubjects getSchoolSubjects() {
        return schoolSubjects;
    }

    public void setSchoolSubjects(SchoolSubjects schoolSubjects) {
        this.schoolSubjects = schoolSubjects;
    }
}
