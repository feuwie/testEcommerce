package diploma.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import diploma.Entity.ProductDAO;
import diploma.Entity.ProfileDAO;
import diploma.Model.Product;

import java.util.List;

@Component
public class ProfileService {

    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    ProfileDAO profileDAO = (ProfileDAO) context.getBean("profileJDBC");

    public List<Product> getProductAll() {
        List<Product> product = profileDAO.getAll();
        return product;
    }
}