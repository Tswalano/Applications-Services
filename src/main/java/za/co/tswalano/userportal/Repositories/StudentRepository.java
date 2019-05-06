package za.co.tswalano.userportal.Repositories;

import za.co.tswalano.userportal.Models.StudentMast;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface StudentRepository extends Repository<StudentMast,Integer> {

    void delete(StudentMast studentMast);

    List<StudentMast> findAll();

    StudentMast findOne(int id);

    StudentMast save(StudentMast studentMast);
}
