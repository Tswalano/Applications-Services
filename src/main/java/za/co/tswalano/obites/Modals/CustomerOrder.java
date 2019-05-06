package za.co.tswalano.obites.Modals;

import javax.persistence.*;

@Entity
public class CustomerOrder {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne
    Menu menu;

    @ManyToOne
    Customers customers;

    public CustomerOrder() {
    }

    public CustomerOrder(Menu menu, Customers customers) {
        this.menu = menu;
        this.customers = customers;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
}
