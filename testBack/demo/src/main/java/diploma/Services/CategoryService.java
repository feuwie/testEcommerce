package diploma.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import diploma.Entity.CategoryDAO;
import diploma.Model.Category;
import java.util.List;

@Component
public class CategoryService {

     ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
     CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryJDBC");

     public List<Category> getCategoryAll() {
          List<Category> category = categoryDAO.getAll();
          return category;
     }
}