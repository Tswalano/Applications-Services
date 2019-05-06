package za.co.tswalano.userportal;

import za.co.tswalano.userportal.Models.*;
import za.co.tswalano.userportal.Repositories.*;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import za.co.tswalano.userportal.Models.*;
import za.co.tswalano.userportal.Repositories.*;

import java.sql.Timestamp;
import java.util.Calendar;

@Component
public class ApplicationInitializer implements CommandLineRunner {

    private GradeMastRepository gradeMastRepository;
    private SchoolCourseRepository courseRepository;
    private SchoolGradeRepository schoolGradeRepository;
    private SchoolMastRepository schoolMastRepository;
    private SchoolSubjectRepository schoolSubjectRepository;
    private StudentCourseMarksRepository studentCourseMarksRepository;
    private StudentRepository studentRepository;
    private SubjectMastRepository subjectMastRepository;
    private SchoolUsersRepository schoolUsersRepository;

    @Autowired
    public ApplicationInitializer(GradeMastRepository gradeMastRepository, SchoolCourseRepository courseRepository,
                                  SchoolGradeRepository schoolGradeRepository, SchoolMastRepository schoolMastRepository,
                                  SchoolSubjectRepository schoolSubjectRepository, StudentCourseMarksRepository studentCourseMarksRepository,
                                  StudentRepository studentRepository, SubjectMastRepository subjectMastRepository,
                                  SchoolUsersRepository schoolUsersRepository) {
        this.gradeMastRepository = gradeMastRepository;
        this.courseRepository = courseRepository;
        this.schoolGradeRepository = schoolGradeRepository;
        this.schoolMastRepository = schoolMastRepository;
        this.schoolSubjectRepository = schoolSubjectRepository;
        this.studentCourseMarksRepository = studentCourseMarksRepository;
        this.studentRepository = studentRepository;
        this.subjectMastRepository = subjectMastRepository;
        this.schoolUsersRepository = schoolUsersRepository;
    }

    @Override
    public void run(String... strings) {

//        Declare calender
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

//Set up the date of birth
        calendar1.set(1995, Calendar.SEPTEMBER, 10);
        calendar2.set(1996, Calendar.MAY, 5);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

//         Hash a password - encrypt the password
        String hashedPassword = BCrypt.hashpw("admin123", BCrypt.gensalt());

        SchoolMast school1 = new SchoolMast("Uptown High School", "Enhlanzeni District");
        SchoolMast school2 = new SchoolMast("Highland Secondary School", "Eastern District");

//        public SchoolUsers(String firstName, String lastName, String username, String emailAddress, String phoneNumber, String password, SchoolMast schoolMast)
        SchoolUsers schoolUsers = new SchoolUsers("Admin","Admin","Admin","admin@admin.com","0111234567","admin123", school1);

//        public SubjectMast(String subjectCode, String subjectName, Date createdAt)
        SubjectMast subjectMast1 = new SubjectMast("ENG", "English");
        SubjectMast subjectMast2 = new SubjectMast("SES", "Sesotho");
        SubjectMast subjectMast3 = new SubjectMast("ZUL", "IsiZulu ");
        SubjectMast subjectMast4 = new SubjectMast("MATH", "Mathematics");
        SubjectMast subjectMast5 = new SubjectMast("MLIT", "Mathematical Literacy");
        SubjectMast subjectMast6 = new SubjectMast("AGRS", "Agricultural Science");
        SubjectMast subjectMast7 = new SubjectMast("ACCN", "Accounting");
        SubjectMast subjectMast8 = new SubjectMast("PHSC ", "Physical Sciences");
        SubjectMast subjectMast9 = new SubjectMast("LFSC ", "Life Sciences");
        SubjectMast subjectMast10 = new SubjectMast("LIFE", "Life Orientation");

//        public GradeMast(String gradeCode, int grade, Date createdAt)
        GradeMast gradeMast1 = new GradeMast("GRD8", 8);
        GradeMast gradeMast2 = new GradeMast("GRD9", 9);
        GradeMast gradeMast3 = new GradeMast("GRD10", 10);
        GradeMast gradeMast4 = new GradeMast("GRD11", 11);
        GradeMast gradeMast5 = new GradeMast("GRD12", 12);

//        public SchoolGrades(String classCode, GradeMast gradeMastId)
        SchoolGrades schoolGrades1 = new SchoolGrades("A",gradeMast1);
        SchoolGrades schoolGrades2 = new SchoolGrades("B",gradeMast1);
        SchoolGrades schoolGrades3 = new SchoolGrades("A",gradeMast2);
        SchoolGrades schoolGrades4 = new SchoolGrades("B",gradeMast2);
        SchoolGrades schoolGrades5 = new SchoolGrades("A",gradeMast3);
        SchoolGrades schoolGrades6 = new SchoolGrades("B",gradeMast3);
        SchoolGrades schoolGrades7 = new SchoolGrades("A",gradeMast4);
        SchoolGrades schoolGrades8 = new SchoolGrades("B",gradeMast4);
        SchoolGrades schoolGrades9 = new SchoolGrades("A",gradeMast5);
        SchoolGrades schoolGrades10 = new SchoolGrades("B",gradeMast5);


//        public SchoolSubjects(String subjectType, String subjectTypeCode, SchoolGrades schoolGrades, SubjectMast subjectMast)
        SchoolSubjects schoolSubjects1 = new SchoolSubjects("Home Language", "HL", schoolGrades1, subjectMast2);
        SchoolSubjects schoolSubjects2 = new SchoolSubjects("First Additional Language", "FAL", schoolGrades1, subjectMast1);
        SchoolSubjects schoolSubjects3 = new SchoolSubjects("Subject One", "ALS", schoolGrades2, subjectMast8);
        SchoolSubjects schoolSubjects4 = new SchoolSubjects("Subject Two", "ALS", schoolGrades2, subjectMast4);
        SchoolSubjects schoolSubjects5 = new SchoolSubjects("Subject Three", "ALS", schoolGrades2, subjectMast4);

        //        public SchoolCourse(String courseName, SchoolMast schoolMast, SchoolSubjects schoolSubjects)
        SchoolCourse course1 = new SchoolCourse("Language Course", school1, schoolSubjects1);
        SchoolCourse course2 = new SchoolCourse("Science Course", school2, schoolSubjects2);
        SchoolCourse course3 = new SchoolCourse("Technology Course", school1, schoolSubjects2);

//        (String firstName, String lastName, Date dateOfBirth, String emailAddress, String phoneNumber, String gender, String IDNumber, String password, Date createdAt)
        StudentMast student1 = new StudentMast("David", "Michelson", calendar1.getTime(), System.currentTimeMillis()+"@edutrack.co.za","0617262421","Male", "9509106101083","password");
        StudentMast student2 = new StudentMast("Jane", "Van Doe", calendar1.getTime(), timestamp.getTime()+"@edutrack.co.za","0836183698","Female", "97870265858574","password");

//        Saving Schools
        this.schoolMastRepository.save(school1);
        this.schoolMastRepository.save(school2);

//        Saving School Users
        this.schoolUsersRepository.save(schoolUsers);

//        Saving Subject Mast
        this.subjectMastRepository.save(subjectMast1);
        this.subjectMastRepository.save(subjectMast2);
        this.subjectMastRepository.save(subjectMast3);
        this.subjectMastRepository.save(subjectMast4);
        this.subjectMastRepository.save(subjectMast5);
        this.subjectMastRepository.save(subjectMast8);

//        Saving grades
        this.gradeMastRepository.save(gradeMast1);
        this.gradeMastRepository.save(gradeMast2);
        this.gradeMastRepository.save(gradeMast3);
        this.gradeMastRepository.save(gradeMast4);
        this.gradeMastRepository.save(gradeMast5);

//        Saving School Grades
        this.schoolGradeRepository.save(schoolGrades1);
        this.schoolGradeRepository.save(schoolGrades2);
        this.schoolGradeRepository.save(schoolGrades3);
        this.schoolGradeRepository.save(schoolGrades4);
        this.schoolGradeRepository.save(schoolGrades5);

//        Saving school subjects
        this.schoolSubjectRepository.save(schoolSubjects1);
        this.schoolSubjectRepository.save(schoolSubjects2);
        this.schoolSubjectRepository.save(schoolSubjects3);
        this.schoolSubjectRepository.save(schoolSubjects4);

//        Saving Courses
        this.courseRepository.save(course1);
        this.courseRepository.save(course2);
        this.courseRepository.save(course3);

//        Saving Students
        this.studentRepository.save(student1);
        this.studentRepository.save(student2);
    }
}
