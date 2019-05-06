package za.co.tswalano.obites.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tswalano.obites.Modals.CustomerOrder;
import za.co.tswalano.obites.Modals.Customers;
import za.co.tswalano.obites.Modals.Menu;
import za.co.tswalano.obites.Repository.CustomerOrderRepository;
import za.co.tswalano.obites.Repository.CustomerRepository;
import za.co.tswalano.obites.Repository.MenuRepository;

import java.util.List;

@Service
public class ApplicationServicesImplementation implements ApplicationServices {

    @Autowired
    private CustomerOrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Customers createCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customers deleteCustomer(int id) {
        Customers customer = findCustomerById(id);
        if (customer != null) {
            customerRepository.delete(customer);
        }
        return customer;
    }

    @Override
    public List<Customers> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customers findCustomerById(int id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customers updateCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    //    Menu
    @Override
    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    //    Customer Order
    @Override
    public CustomerOrder createOrder(CustomerOrder order) {
        return orderRepository.save(order);
    }

}
