package za.co.tswalano.obites.Services;

import org.springframework.context.annotation.ComponentScan;
import za.co.tswalano.obites.Modals.CustomerOrder;
import za.co.tswalano.obites.Modals.Customers;
import za.co.tswalano.obites.Modals.Menu;

import java.util.List;

@ComponentScan
public interface ApplicationServices {

    Customers createCustomer(Customers customer);

    Customers deleteCustomer(int id);

    List<Customers> findAllCustomers();

    Customers findCustomerById(int id);

    Customers updateCustomer(Customers customer);

    //    Menu
    Menu createMenu(Menu menu);

    //    Customer Order
    CustomerOrder createOrder(CustomerOrder order);
}
