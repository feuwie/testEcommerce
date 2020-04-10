package diploma.Entity;

import diploma.DAO.ProductInterface;
import diploma.Mappers.ProductMapper;
import diploma.Model.Product;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import javax.sql.DataSource;

@Component
public class ProductDAO implements ProductInterface<Product> {
    public DataSource dataSource;
    public JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> getAll() {
        String SQL = "select * from Products";
        List<Product> products = jdbcTemplateObject.query(SQL, new ProductMapper());
        return products;
    }

    @Override
    public List<Product> getOneArticle(Integer article) {
        String SQL = "select * from Products where article = ?";
        List<Product> products = jdbcTemplateObject.query(SQL, new ProductMapper(), article);
        return products;
    }

    @Override
    public List<Product> getOneParent(Integer parent) {
        String SQL = "select * from Products where parent_id = ?";
        List<Product> products = jdbcTemplateObject.query(SQL, new ProductMapper(), parent);
        return products;
    }

    @Override
    public List<Product> getOneTitle(String title) {
        title = "%" + title + "%";
        String SQL = "select * from Products where title like ?";
        List<Product> products = jdbcTemplateObject.query(SQL, new ProductMapper(), title);
        return products;
    }
}