package diploma.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import diploma.Entity.AdminDAO;
import diploma.Model.User;

@Component
public class AdminService {

    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    AdminDAO adminDAO = (AdminDAO) context.getBean("adminJDBC");

    public User getUser(String email, String password, String role) {
        User result = adminDAO.getUser(email, password, role);
        return result;
    }
}