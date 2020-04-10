package diploma.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import diploma.Entity.WishDAO;
import diploma.Model.Wish;

import java.util.List;

@Component
public class WishService {

    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    WishDAO wishDAO = (WishDAO) context.getBean("wishJDBC");

    public Wish addWishlist(Integer id, String img, String title, Integer price, Integer article) {
        Wish result = wishDAO.createWishlist(id, img, title, price, article);
        return result;
    }

    public Wish delWishlist(Integer id) {
        Wish result = wishDAO.deleteWishlist(id);
        return result;
    }

    public List<Wish> getWishlistAll() {
        List<Wish> result = wishDAO.getAllWishlist();
        return result;
    }
}