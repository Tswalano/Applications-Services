package za.co.tswalano.userportal.Services;

import za.co.tswalano.userportal.Models.SchoolCourse;
import za.co.tswalano.userportal.Models.SchoolMast;
import za.co.tswalano.userportal.Models.SchoolUsers;
import za.co.tswalano.userportal.Models.StudentMast;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
public interface ApplicationServices {

    StudentMast createStudent(StudentMast studentMast);

    StudentMast deleteStudent(int id);

    List<StudentMast> findAllStudents();

    StudentMast findStudentById(int id);

    StudentMast updateStudent(StudentMast studentMast);

    //    Course
    List<SchoolCourse> findAllCourses();

    //    School Mast
    List<SchoolMast> findAllSchools();

    //    School Users
    List<SchoolUsers> findAllSchoolUsers();
}
