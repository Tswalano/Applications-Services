package za.co.tswalano.userportal.Repositories;

import za.co.tswalano.userportal.Models.SchoolSubjects;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SchoolSubjectRepository extends Repository<SchoolSubjects, Integer> {
    void delete(SchoolSubjects studentMast);

    List<SchoolSubjects> findAll();

    SchoolSubjects findOne(int id);

    SchoolSubjects save(SchoolSubjects SchoolSubjects);

}
