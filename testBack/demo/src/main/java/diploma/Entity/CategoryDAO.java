package diploma.Entity;

import diploma.DAO.CategoryInterface;
import diploma.Mappers.CategoryMapper;
import diploma.Model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import javax.sql.DataSource;

@Component
public class CategoryDAO implements CategoryInterface<Category> {

   public DataSource dataSource;
   public JdbcTemplate jdbcTemplateObject;

   @Override
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   @Override
   public List<Category> getAll() {
      String SQL = "select * from Categories";
      List<Category> categories = jdbcTemplateObject.query(SQL, new CategoryMapper());
      return categories;
   }
}