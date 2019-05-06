package za.co.tswalano.userportal.Repositories;

import za.co.tswalano.userportal.Models.SchoolCourse;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SchoolCourseRepository extends Repository<SchoolCourse,Integer> {

    void delete(SchoolCourse schoolCourse);

    List<SchoolCourse> findAll();

    SchoolCourse findOne(int id);

    SchoolCourse save(SchoolCourse schoolCourse);
}
