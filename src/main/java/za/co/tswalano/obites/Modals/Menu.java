package za.co.tswalano.obites.Modals;

import javax.persistence.*;

@Entity
public class Menu {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column
    private String Menu;

    @Column
    private double Price;

    @Column
    private String MenuName;

    @Column
    private String ImagePath;

    public Menu() {
    }

    public Menu(String menu, double price, String menuName, String imagePath) {
        Menu = menu;
        Price = price;
        MenuName = menuName;
        ImagePath = imagePath;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }
}
