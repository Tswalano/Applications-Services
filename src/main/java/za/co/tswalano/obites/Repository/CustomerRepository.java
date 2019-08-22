package za.co.tswalano.obites.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import za.co.tswalano.obites.Modals.Customers;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends Repository<Customers, Integer> {
    Customers save(Customers customers);

    List<Customers> findAll();

    @Query("SELECT u from Customers u WHERE u.Username = 'JD'")
    List<Customers> findAllByName();

    @Query("SELECT u from Customers u WHERE u.Username = :u AND u.Password = :p")
    @Transactional
    @Modifying
    List<Customers> findCustomersByUsernameAndPassword(@Param("u") String u, @Param("p") String p);

//    Update & Insert Queries: Hint -> @Modifying

}
