package diploma.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import diploma.Entity.UserDAO;
import diploma.Model.User;

@Component
public class UserService {

    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    UserDAO userDAO = (UserDAO) context.getBean("userJDBC");

    public User getUser(String email, String password, String role) {
        User result = userDAO.getUser(email, password, role);
        return result;
    }

    public User regUser(User user) {
        User result = userDAO.regUser(user);
        return result;
    }

}