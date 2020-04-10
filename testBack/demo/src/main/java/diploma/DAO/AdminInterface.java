package diploma.DAO;

import javax.sql.DataSource;

public interface AdminInterface<T> {
    public void setDataSource(DataSource ds);
    public Object getUser(String email, String password, String role);
}