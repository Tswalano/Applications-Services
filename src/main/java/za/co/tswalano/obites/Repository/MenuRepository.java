package za.co.tswalano.obites.Repository;

import org.springframework.data.repository.Repository;
import za.co.tswalano.obites.Modals.Menu;

import java.util.List;

public interface MenuRepository extends Repository<Menu, Integer> {

//    void delete(Menu menu);
//
//    List<Menu> findAll();
//
//    Menu findMenuBy(int id);
//
    Menu save(Menu menu);
}
