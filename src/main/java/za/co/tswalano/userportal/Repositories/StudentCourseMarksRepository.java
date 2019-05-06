package za.co.tswalano.userportal.Repositories;

import za.co.tswalano.userportal.Models.StudentCourseMarks;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface StudentCourseMarksRepository extends Repository<StudentCourseMarks, Integer> {
    void delete(StudentCourseMarks studentMast);

    List<StudentCourseMarks> findAll();

    StudentCourseMarks findOne(int id);

    StudentCourseMarks save(StudentCourseMarks StudentCourseMarks);
}
