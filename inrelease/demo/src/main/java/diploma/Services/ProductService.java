package diploma.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import diploma.Entity.ProductDAO;
import diploma.Model.Product;
import diploma.Model.Promo;

import java.util.List;

@Component
public class ProductService {

     ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
     ProductDAO productDAO = (ProductDAO) context.getBean("productJDBC");

     public Product addWishlist(Integer id, String img, String title, Integer price, Integer article) {
          Product product = productDAO.createWishlist(id, img, title, price, article);
          return product;
     }

     public Product delWishlist(Integer id) {
          Product product = productDAO.deleteWishlist(id);
          return product;
     }

     public List<Product> getWishlistAll() {
          List<Product> product = productDAO.getAllWishlist();
          return product;
     }

     public List<Promo> getPromoAll() {
          List<Promo> product = productDAO.getAllPromo();
          return product;
     }

     public Product addCart(Integer id, String img, String title, Integer price, Integer article, Integer qty ) {
          Product product = productDAO.createCart(id, img, title, price, article, qty);
          return product;
     }

     public Product updCart(Integer id, Integer qty) {
          Product product = productDAO.updateCart(id, qty);
          return product;
     }

     public Product delCart(Integer id) {
          Product product = productDAO.deleteCart(id);
          return product;
     }

     public List<Product> getCartAll() {
          List<Product> product = productDAO.getAllCart();
          return product;
     }

     public List<Product> getProductAll() {
          List<Product> product = productDAO.getAll();
          return product;
     }

     public List<Product> getProductAricle(Integer article) {
          List<Product> product = productDAO.getOneArticle(article);
          return product;
     }

     public List<Product> getProductParent(Integer parent) {
          List<Product> product = productDAO.getOneParent(parent);
          return product;
     }

     public List<Product> getProductTitle(String title) {
          List<Product> product = productDAO.getOneTitle(title);
          return product;
     }
}