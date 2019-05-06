package za.co.tswalano.userportal.Repositories;

import za.co.tswalano.userportal.Models.SchoolUsers;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SchoolUsersRepository extends Repository<SchoolUsers, Integer> {

    void delete(SchoolUsers studentMast);

    List<SchoolUsers> findAll();

    SchoolUsers findOne(int id);

    SchoolUsers save(SchoolUsers schoolUsers);
}
