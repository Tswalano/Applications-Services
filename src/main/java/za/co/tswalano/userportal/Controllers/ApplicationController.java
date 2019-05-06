package za.co.tswalano.userportal.Controllers;

import za.co.tswalano.userportal.Models.SchoolCourse;
import za.co.tswalano.userportal.Models.SchoolMast;
import za.co.tswalano.userportal.Models.SchoolUsers;
import za.co.tswalano.userportal.Models.StudentMast;
import za.co.tswalano.userportal.Services.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class ApplicationController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

//    StudentMast Controllers

    @Autowired
    private ApplicationServices applicationServices;

    @PostMapping
    public StudentMast createStudent(@RequestBody StudentMast studentMast) {
        return applicationServices.createStudent(studentMast);
    }

    @GetMapping(path = "/{id}")
    public StudentMast findStudent(@PathVariable("id") int id) {
        return applicationServices.findStudentById(id);
    }

    @PutMapping(path = {"/{id}"})
    public StudentMast update(@PathVariable("id") int id, @RequestBody StudentMast studentMast) {
        studentMast.setStudent_ID(id);
        return applicationServices.updateStudent(studentMast);
    }

    @DeleteMapping(path = {"/{id}"})
    public StudentMast deleteStudent(@PathVariable("id") int id) {
        return applicationServices.deleteStudent(id);
    }

    @GetMapping
    public List<StudentMast> findAllStudents() {
        return applicationServices.findAllStudents();
    }

    //  AppClasses Course-Marks Controllers
    @GetMapping(path = "/all-courses")
    public List<SchoolCourse> findAllCourses() {
        return applicationServices.findAllCourses();
    }

    //  SchoolMast Controllers
    @GetMapping(path = "/schools")
    public List<SchoolMast> findAllSchools() {
        return applicationServices.findAllSchools();
    }

    @GetMapping(path = "/schoolCourse/{id}")
    public List<Object> findAllCoursesBySchoolID(@PathVariable("id") int id) {

        @SuppressWarnings("unchecked")
        Query query = entityManager.createQuery("SELECT A FROM SchoolCourse A JOIN A.schoolMast B WHERE B.id = :schoolID");
        query.setParameter("schoolID", id);
        List<Object> courseList = query.getResultList();

        return courseList;
    }

    @GetMapping(path = "/schoolSubjects/{id}")
    public List<SchoolCourse> findAllSchoolSubjectsBySchoolID(@PathVariable("id") int id) {

        @SuppressWarnings("unchecked")
        Query query = entityManager.createQuery("SELECT SC FROM SchoolCourse SC " +
                "JOIN SC.schoolSubjects SS " +
                "JOIN SS.schoolGrades   SG " +
                "JOIN SS.subjectMast    SM " +
                "JOIN SC.schoolMast     S WHERE S.id = :schoolID");
        query.setParameter("schoolID", id);
        List<SchoolCourse> schoolCourses = query.getResultList();

        if (schoolCourses == null) {
            System.out.println("No AppClasses found . ");
        } else {
            for (SchoolCourse empl : schoolCourses) {
                System.err.println(empl.getCourseName() + "\t\t\t" + empl.getSchoolMast().getSchoolName());
            }
        }

        return schoolCourses;
    }

//    @PostMapping(value = "/testCase1", produces = "application/json")
    @RequestMapping(value = "/testCase1", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<SchoolUsers> getUser1(@RequestBody SchoolUsers users) {
        try{
            return new ResponseEntity<SchoolUsers>(users, HttpStatus.OK);
        }catch(Exception e ){
             e.getMessage();
            return null;
        }

    }

//    @PostMapping(value = "/validateUser", produces = "application/json")
    @RequestMapping( value="/validateUser", method = RequestMethod.POST, produces="application/json")
    public List<SchoolUsers> getUser(@RequestBody SchoolUsers users) {

        System.err.println(users.getUsername());
        System.err.println(users.getPassword());

        @SuppressWarnings("unchecked")
        Query query = entityManager.createQuery("SELECT e FROM SchoolUsers e " +
                "WHERE e.Username = :username AND e.Password = :password");
        query.setParameter("username", users.getUsername());
        query.setParameter("password", users.getPassword());

        return query.getResultList();
    }


//    @GetMapping(path = "/validateSchoolUsers")
//    public List<SchoolUsers> checkIfUserExists(@RequestBody String username) {
//
//        @SuppressWarnings("unchecked")
//        Query query = entityManager.createQuery("SELECT e FROM SchoolUsers e " +
//                "WHERE e.Username = :username AND e.Password = :password");
//        query.setParameter("username", username);
//        query.setParameter("password", "admin123");
//
//        List<SchoolUsers> schoolUsers = query.getResultList();
//
//        try {
//            if (schoolUsers == null) {
////                No Data
//
//            } else {
////                Data found
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
//
//        return schoolUsers;
//    }

    @PostMapping(path = "/logUser")
    public StudentMast logUser(@RequestBody StudentMast studentMast) {
        return applicationServices.createStudent(studentMast);
    }
}
