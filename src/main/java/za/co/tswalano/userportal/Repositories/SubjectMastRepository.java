package za.co.tswalano.userportal.Repositories;

import za.co.tswalano.userportal.Models.SubjectMast;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SubjectMastRepository extends Repository<SubjectMast, Integer> {
        void delete(SubjectMast studentMast);

        List<SubjectMast> findAll();

        SubjectMast findOne(int id);

        SubjectMast save(SubjectMast SubjectMast);
}
