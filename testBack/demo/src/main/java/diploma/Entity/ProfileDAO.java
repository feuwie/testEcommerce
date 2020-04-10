package diploma.Entity;

import diploma.DAO.ProductInterface;
import diploma.DAO.ProfileInterface;
import diploma.Mappers.ProductMapper;
import diploma.Model.Product;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import javax.sql.DataSource;

@Component
public class ProfileDAO implements ProfileInterface<Product> {
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

    // @Override
    // public User checkToken(String email, String password, String role) {
    //     String SQL = "select * from user where email = ? AND password = ? AND usertype = ?";
    //     try {
    //         User result = jdbcTemplateObject.queryForObject(SQL, new UserMapper(), email, password, role);
    //         return result;
    //     } catch (EmptyResultDataAccessException e) {
    //         return null;
    //     }
    // }

}