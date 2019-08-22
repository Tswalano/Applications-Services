package za.co.tswalano.obites.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tswalano.obites.Modals.Customers;
import za.co.tswalano.obites.Modals.MakeOrder;
import za.co.tswalano.obites.Repository.CustomerRepository;
import za.co.tswalano.obites.Services.ApplicationServices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class ApplicationController {

    @Autowired
    private ApplicationServices applicationServices;

//  Get all customers
    @GetMapping
    public List<Customers> findCustomers() {
        return applicationServices.findAllCustomers();
    }

//  Create customer
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST, produces = "application/json")
    public Customers createCustomers(@RequestBody Customers customers) {
        return applicationServices.createCustomer(customers);
    }

//  Get all customers
    @GetMapping(value = "/test1")
    public List<Customers> findAllQuery() {
        return applicationServices.findAllQuery();
    }

//  Get customers by credentials
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public List<Customers> findCustomerCredentials(@RequestBody Customers customers) {
        System.err.println("Username: " + customers.getUsername() + " Password: " + customers.getPassword());
        return applicationServices.findCustomerByCredentials(customers.getUsername(), customers.getPassword());
    }
}
