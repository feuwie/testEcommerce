package diploma.Entity;

import diploma.DAO.CartInterface;
import diploma.Mappers.CartMapper;
import diploma.Model.Cart;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import javax.sql.DataSource;

@Component
public class CartDAO implements CartInterface<Cart> {
    public DataSource dataSource;
    public JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public Cart createCart(Integer id, String img, String title, Integer price, Integer article, Integer qty) {
        String insertQuery = "insert into Cart (id, img, title, price, article, qty) values (?, ?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(insertQuery, id, img, title, price, article, qty);
        return null;
    }

    @Override
    public Cart updateCart(Integer id, Integer qty) {
        String SQL = "update Cart set qty = ? where id = ?";
        jdbcTemplateObject.update(SQL, qty, id);
        return null;
    }

    @Override
    public Cart deleteCart(Integer id) {
        String SQL = "delete from Cart where id = ?";
        jdbcTemplateObject.update(SQL, id);
        return null;
    }

    @Override
    public List<Cart> getAllCart() {
        String SQL = "select * from Cart";
        List<Cart> result = jdbcTemplateObject.query(SQL, new CartMapper());
        return result;
    }
}