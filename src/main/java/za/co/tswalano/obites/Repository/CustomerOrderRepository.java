package za.co.tswalano.obites.Repository;

import org.springframework.data.repository.Repository;
import za.co.tswalano.obites.Modals.CustomerOrder;

import java.util.List;

public interface CustomerOrderRepository extends Repository<CustomerOrder, Integer> {

//    void delete(CustomerOrder order);
//
//    List<CustomerOrder> findAll();
//
////    CustomerOrder findCustomerOrderBy(int id);
//
    CustomerOrder save(CustomerOrder order);
}
