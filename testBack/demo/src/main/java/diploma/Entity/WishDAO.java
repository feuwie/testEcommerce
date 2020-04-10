package diploma.Entity;

import diploma.DAO.WishInterface;
import diploma.Mappers.WishMapper;
import diploma.Model.Wish;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import javax.sql.DataSource;

@Component
public class WishDAO implements WishInterface<Wish> {
    public DataSource dataSource;
    public JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public Wish createWishlist(Integer id, String img, String title, Integer price, Integer article) {
        String insertQuery = "insert into Wishlist (id, img, title, price, article) values (?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(insertQuery, id, img, title, price, article);
        return null;
    }

    @Override
    public Wish deleteWishlist(Integer id) {
        String SQL = "delete from Wishlist where id = ?";
        jdbcTemplateObject.update(SQL, id);
        return null;
    }

    @Override
    public List<Wish> getAllWishlist() {
        String SQL = "select * from Wishlist";
        List<Wish> products = jdbcTemplateObject.query(SQL, new WishMapper());
        return products;
    }
}