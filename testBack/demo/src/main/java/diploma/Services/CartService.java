package diploma.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import diploma.Entity.CartDAO;
import diploma.Model.Cart;

import java.util.List;

@Component
public class CartService {

    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    CartDAO cartDAO = (CartDAO) context.getBean("cartJDBC");

    public Cart addCart(Integer id, String img, String title, Integer price, Integer article, Integer qty) {
        Cart result = cartDAO.createCart(id, img, title, price, article, qty);
        return result;
    }

    public Cart updCart(Integer id, Integer qty) {
        Cart result = cartDAO.updateCart(id, qty);
        return result;
    }

    public Cart delCart(Integer id) {
        Cart result = cartDAO.deleteCart(id);
        return result;
    }

    public List<Cart> getCartAll() {
        List<Cart> result = cartDAO.getAllCart();
        return result;
    }
}