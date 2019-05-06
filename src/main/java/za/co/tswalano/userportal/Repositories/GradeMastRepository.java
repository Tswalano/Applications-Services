package za.co.tswalano.userportal.Repositories;

import za.co.tswalano.userportal.Models.GradeMast;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface GradeMastRepository extends Repository<GradeMast, Integer> {
    void delete(GradeMast studentMast);

    List<GradeMast> findAll();

    GradeMast findOne(int id);

    GradeMast save(GradeMast gradeMast);


}
