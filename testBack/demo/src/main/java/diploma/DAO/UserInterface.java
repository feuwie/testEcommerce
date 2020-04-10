package diploma.DAO;

import javax.sql.DataSource;
import diploma.Model.User;

public interface UserInterface<T> {
    public void setDataSource(DataSource ds);
    public Object getUser(String email, String password, String role);
    public Object regUser(User user);
}