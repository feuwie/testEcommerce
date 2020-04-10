package diploma.DAO;

import java.util.List;

import javax.sql.DataSource;

public interface ProductInterface<T> {
   public void setDataSource(DataSource ds);

   public List<T> getAll();

   public List<T> getOneArticle(Integer article);

   public List<T> getOneParent(Integer parent);

   public List<T> getOneTitle(String title);
}