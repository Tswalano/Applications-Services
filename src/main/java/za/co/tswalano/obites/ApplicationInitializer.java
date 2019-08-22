package za.co.tswalano.obites;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import za.co.tswalano.obites.Modals.CustomerOrder;
import za.co.tswalano.obites.Modals.Customers;
import za.co.tswalano.obites.Modals.Menu;
import za.co.tswalano.obites.Repository.CustomerOrderRepository;
import za.co.tswalano.obites.Repository.CustomerRepository;
import za.co.tswalano.obites.Repository.MenuRepository;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class ApplicationInitializer implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

    private CustomerRepository customerRepository;
    private CustomerOrderRepository orderRepository;
    private MenuRepository menuRepository;

    @Autowired
    public ApplicationInitializer(CustomerRepository customerRepository,
                                  CustomerOrderRepository orderRepository,
                                  MenuRepository menuRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
    }

//    @Override
//    public void run(String... strings) {
//
//
//        Customers customer = new Customers("Admin", "Admin", "Admin", "admin@admin.com", "0617262421", "admin123");
//
//        Menu menu1 = new Menu("Beef, Salad, Stew Soap, Cabbage and Rice", 45.0, "Beef Plate", "");
//        Menu menu2 = new Menu("Pap, Chicken, Soup and Salad", 32.8, "Chicken Plate", "");
//        Menu menu3 = new Menu("4 Slice, Achar, Cheese, Vienna and Egg", 45.0, "Kota Cheese", "");
//        Menu menu4 = new Menu("Pap, chips, Salad, Soup, Beef and Source", 45.0, "Full Plate and Beef", "");
//        Menu menu5 = new Menu("Fish, Chips, Source, Half Bread", 32.90, "Fish & Chips", "");
//
//        CustomerOrder customerOrder = new CustomerOrder(menu1, customer);
//
//        this.customerRepository.save(customer);
//
////        this.menuRepository.save(menu1);
////        this.menuRepository.save(menu2);
////        this.menuRepository.save(menu3);
////        this.menuRepository.save(menu4);
////        this.menuRepository.save(menu5);
////
////        this.orderRepository.save(customerOrder);
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String strArgs = Arrays.stream(args.getSourceArgs()).collect(Collectors.joining("|"));
        logger.info("Application started with arguments:" + strArgs);

        Customers customer = new Customers("Admin", "Admin", "Admin", "admin@admin.com", "0617262421", "admin123");

        Menu menu1 = new Menu("Beef, Salad, Stew Soap, Cabbage and Rice", 45.0, "Beef Plate", "");
        Menu menu2 = new Menu("Pap, Chicken, Soup and Salad", 32.8, "Chicken Plate", "");
        Menu menu3 = new Menu("4 Slice, Achar, Cheese, Vienna and Egg", 45.0, "Kota Cheese", "");
        Menu menu4 = new Menu("Pap, chips, Salad, Soup, Beef and Source", 45.0, "Full Plate and Beef", "");
        Menu menu5 = new Menu("Fish, Chips, Source, Half Bread", 32.90, "Fish & Chips", "");

        CustomerOrder customerOrder = new CustomerOrder(menu1, customer);

        this.customerRepository.save(customer);

        this.menuRepository.save(menu1);
        this.menuRepository.save(menu2);
        this.menuRepository.save(menu3);
        this.menuRepository.save(menu4);
        this.menuRepository.save(menu5);

        this.orderRepository.save(customerOrder);
    }
}
