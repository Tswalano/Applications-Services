package za.co.tswalano.userportal.Repositories;

import za.co.tswalano.userportal.Models.SchoolGrades;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SchoolGradeRepository extends Repository<SchoolGrades, Integer> {
    void delete(SchoolGrades studentMast);

    List<SchoolGrades> findAll();

    SchoolGrades findOne(int id);

    SchoolGrades save(SchoolGrades SchoolGrades);
    
}
