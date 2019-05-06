package za.co.tswalano.obites.Repository;

import org.springframework.data.repository.Repository;
import za.co.tswalano.obites.Modals.Customers;
import java.util.List;

public interface CustomerRepository extends Repository<Customers, Integer> {

    void delete(Customers customers);

    List<Customers> findAll();

    Customers findOne(int id);

    Customers save(Customers customers);

}
