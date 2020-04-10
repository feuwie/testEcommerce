package diploma.DAO;

import java.util.List;

import javax.sql.DataSource;

public interface ProfileInterface<T> {
    public void setDataSource(DataSource ds);

    public List<T> getAll();
    
    // public Object checkToken();


}