package za.co.tswalano.obites.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tswalano.obites.Modals.Customer;
import za.co.tswalano.obites.Modals.Customers;
import za.co.tswalano.obites.Modals.MakeOrder;
import za.co.tswalano.obites.Services.ApplicationServices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class ApplicationController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Autowired
    private ApplicationServices applicationServices;

    @PostMapping
    public Customers createCustomers(@RequestBody Customers customers) {
        return applicationServices.createCustomer(customers);
    }

    @GetMapping(path = "/{id}")
    public Customers findCustomer(@PathVariable("id") int id) {
        return applicationServices.findCustomerById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Customers update(@PathVariable("id") int id, @RequestBody Customers customer) {
        customer.getID();
        return applicationServices.updateCustomer(customer);
    }

    @DeleteMapping(path = {"/{id}"})
    public Customers deletCustomers(@PathVariable("id") int id) {
        return applicationServices.deleteCustomer(id);
    }

    @GetMapping
    public List<Customers> findAllStudents() {
        return applicationServices.findAllCustomers();
    }

    //    Login
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public List<Customers> getUser(@RequestBody Customers customer) {

        System.err.println(customer.getUsername());
        System.err.println(customer.getPassword());

        @SuppressWarnings("unchecked")
        Query query = entityManager.createQuery("SELECT e FROM Customers e " +
                "WHERE e.Username = :username AND e.Password = :password");
        query.setParameter("username", customer.getUsername());
        query.setParameter("password", customer.getPassword());

        return query.getResultList();
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = "application/json")
    public int getOrder(@RequestBody MakeOrder order) {
//        Set up status code response for different failure e.g return 200 if everything below is a success
//        Insert Customer Order to DB
//        Extract Customer number
//        Validate Customer Number
//        Send the customer order recieved message using Twilio SMS or WhatsApp

//        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
        try {

            System.out.flush();

            System.err.println("#######################################################");
            System.err.println("==================== ORDER DETAILS ====================");
            System.err.println("#######################################################");

            System.err.println("Order Name: \t\t\t" + order.getOrderName());
            System.err.println("Order Cost: \t\t\t" + "R" + order.getOrderCost() + ".00");

            System.err.print("Ingredients: \t\t\t");
            for (int i = 0; i < order.getIngredients().size(); i++) {
                System.err.print(order.getIngredients().get(i) + ", ");
            }
            System.err.println();
            System.err.println();
            System.err.println("#######################################################");
            System.err.println("=================== CUSTOMER DETAILS ==================");
            System.err.println("#######################################################");

            System.err.println("Cust. Name:\t\t\t\t" + order.getFirstName() + " " + order.getLastName());
            System.err.println("Cust. Cell:\t\t\t\t" + order.getNumber());
            System.err.println("Cust. Addr:\t\t\t\t" + order.getAddress());
            System.err.println("Cust. Comp:\t\t\t\t" + order.getAddress2());

            return 200;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            return 202;
        }
    }
}
