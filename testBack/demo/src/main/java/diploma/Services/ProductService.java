package diploma.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import diploma.Entity.ProductDAO;
import diploma.Model.Product;

import java.util.List;

@Component
public class ProductService {

     ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
     ProductDAO productDAO = (ProductDAO) context.getBean("productJDBC");

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