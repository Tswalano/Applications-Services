package za.co.tswalano.userportal.Repositories;

import za.co.tswalano.userportal.Models.SchoolMast;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SchoolMastRepository extends Repository<SchoolMast, Integer> {

    void delete(SchoolMast studentMast);

    List<SchoolMast> findAll();

    SchoolMast findOne(int id);

    SchoolMast save(SchoolMast schoolMast);
}
