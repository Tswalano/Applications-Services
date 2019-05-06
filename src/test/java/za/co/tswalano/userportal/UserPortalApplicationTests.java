package za.co.tswalano.userportal;

import za.co.tswalano.userportal.Models.*;
import za.co.tswalano.userportal.Models.SchoolCourse;
import za.co.tswalano.userportal.Models.SchoolUsers;
import za.co.tswalano.userportal.Models.StudentMast;
import org.hibernate.HibernateException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPortalApplicationTests {


    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Test
    public void contextLoads() {
    }

    @Test
    public void initEntityManager() throws HibernateException {

        // get all the objects from Employee table
        @SuppressWarnings("unchecked")
        List<StudentMast> studentList = entityManager.createQuery("SELECT e FROM StudentMast e WHERE e.id = 1").getResultList();

        if (studentList == null) {
            System.out.println("No AppClasses found . ");
        } else {
            for (StudentMast empl : studentList) {
                System.err.println("AppClasses name= " + empl.getFirstName() + ", AppClasses id " + empl.getStudent_ID());
            }
        }
    }

//    Get SchoolCourse By School ID

    @Test
    public void getSchoolCourseBySchoolID() {
        @SuppressWarnings("unchecked")
        Query query = entityManager.createQuery("SELECT SC FROM SchoolCourse SC " +
                "JOIN SC.schoolSubjects SS " +
                "JOIN SS.schoolGrades   SG " +
                "JOIN SS.subjectMast    SM " +
                "JOIN SC.schoolMast     S WHERE S.id = :schoolID");
        query.setParameter("schoolID", 1);
        List<SchoolCourse> schoolCourses = query.getResultList();

        if (schoolCourses == null) {
            System.out.println("No AppClasses found . ");
        } else {
            for (SchoolCourse empl : schoolCourses) {
                System.err.println(empl.getCourseName() + "\t\t\t\t" + empl.getSchoolMast().getSchoolName());
            }
        }
    }

    @Test
    public void checkIfUserExists(){
        boolean isValidUser = false;

        @SuppressWarnings("unchecked")
        Query query = entityManager.createQuery("SELECT e FROM SchoolUsers e " +
                "WHERE e.Username = :username AND e.Password = :password");
        query.setParameter("username", "admin");
        query.setParameter("password", "admin123");

        List<SchoolUsers> schoolUsers = query.getResultList();

        try {
            if (schoolUsers == null) {
                System.err.println("No AppClasses found . ");
            } else {
                isValidUser = true;
                for (SchoolUsers users : schoolUsers) {
                    System.err.println(users.getEmailAddress() + "\t\t\t\t" + users.getUsername());
                }
            }
        }catch (Exception e){
            isValidUser = false;
            e.getMessage();
        }

        System.err.println(isValidUser);
    }

    @BeforeClass
    public static void beginTran() throws HibernateException{
        System.out.println("Starting Transaction...");
        entityManager.getTransaction().begin();
    }

    @AfterClass
    public static void endTran() throws HibernateException{
        // close the entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}
