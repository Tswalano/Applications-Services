package za.co.tswalano.obites.Services;

import org.springframework.stereotype.Service;
import za.co.tswalano.obites.Modals.CustomerOrder;
import za.co.tswalano.obites.Modals.Customers;
import za.co.tswalano.obites.Modals.Menu;

import java.util.List;

@Service
public interface ApplicationServices {
//  Customers Services
    Customers createCustomer(Customers customer);
//  Find all users
    List<Customers> findAllCustomers();

    List<Customers> findAllQuery();

    List<Customers> findCustomerByCredentials(String u, String p);
}
