package za.co.tswalano.obites.Modals;

import java.util.ArrayList;

public class MakeOrder {

    String orderName;
    String orderCost;
    ArrayList ingredients;

    String firstName;
    String lastName;
    String address;
    String address2;
    String number;


    public MakeOrder() {
    }

    public MakeOrder(String orderName, String orderCost, ArrayList ingredients, String firstName, String lastName, String address, String address2, String number) {
        this.orderName = orderName;
        this.orderCost = orderCost;
        this.ingredients = ingredients;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.address2 = address2;
        this.number = number;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    public ArrayList getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList ingredients) {
        this.ingredients = ingredients;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
