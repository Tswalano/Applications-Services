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
    private CustomerRepository customerRepository;

//    Create Order
    @Override
    public Customers createCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

//    find all customers
    @Override
    public List<Customers> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customers> findAllQuery() {
        return customerRepository.findAllByName();
    }

    @Override
    public List<Customers> findCustomerByCredentials(String u, String p) {
        return customerRepository.findCustomersByUsernameAndPassword(u,p);
    }

}