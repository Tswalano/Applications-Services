package za.co.tswalano.userportal.Services;

import za.co.tswalano.userportal.Models.SchoolCourse;
import za.co.tswalano.userportal.Models.SchoolMast;
import za.co.tswalano.userportal.Models.SchoolUsers;
import za.co.tswalano.userportal.Models.StudentMast;
import za.co.tswalano.userportal.Repositories.SchoolCourseRepository;
import za.co.tswalano.userportal.Repositories.SchoolMastRepository;
import za.co.tswalano.userportal.Repositories.SchoolUsersRepository;
import za.co.tswalano.userportal.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServicesImplementation implements ApplicationServices {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolCourseRepository courseRepository;
    @Autowired
    private SchoolMastRepository schoolMastRepository;
    @Autowired
    private SchoolUsersRepository schoolUsersRepository;

    @Override
    public StudentMast createStudent(StudentMast studentMast) {
        return studentRepository.save(studentMast);
    }

    @Override
    public StudentMast deleteStudent(int id) {
        StudentMast studentMast = findStudentById(id);
        if (studentMast != null) {
            studentRepository.delete(studentMast);
        }
        return studentMast;
    }

    @Override
    public List<StudentMast> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentMast findStudentById(int id) {
        return studentRepository.findOne(id);
    }

    @Override
    public StudentMast updateStudent(StudentMast studentMast) {
        return studentRepository.save(studentMast);
    }

    // School Course
    @Override
    public List<SchoolCourse> findAllCourses() {
        return courseRepository.findAll();
    }

    //SchoolMast
    @Override
    public List<SchoolMast> findAllSchools(){
        return schoolMastRepository.findAll();
    }

    @Override
    public List<SchoolUsers> findAllSchoolUsers() {
        return schoolUsersRepository.findAll();
    }
}
