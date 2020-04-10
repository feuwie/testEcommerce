package diploma.DAO;

import java.util.List;

import javax.sql.DataSource;

public interface StudentInterface<T> {
   public void setDataSource(DataSource ds);
   public List<T> getAll();
   public List<T> getOne(Integer id);
   public Object update(Integer id, String name, Integer age);
   public Object create(String name, Integer age);
   public Object delete(Integer id);
}