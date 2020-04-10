package diploma.Entity;

import diploma.DAO.ProductInterface;
import diploma.Mappers.CartMapper;
import diploma.Mappers.ProductMapper;
import diploma.Mappers.WishlistMapper;
import diploma.Mappers.PromoMapper;
import diploma.Model.Product;
import diploma.Model.Promo;

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
    public Product createWishlist(Integer id, String img, String title, Integer price, Integer article) {
        String insertQuery = "insert into Wishlist (id, img, title, price, article) values (?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(insertQuery, id, img, title, price, article);
        return null;
    }

    @Override
    public Product deleteWishlist(Integer id) {
        String SQL = "delete from Wishlist where id = ?";
        jdbcTemplateObject.update(SQL, id);
        return null;
    }

    @Override
    public List<Product> getAllWishlist() {
        String SQL = "select * from Wishlist";
        List<Product> products = jdbcTemplateObject.query(SQL, new WishlistMapper());
        return products;
    }

    @Override
    public List<Promo> getAllPromo() {
        String SQL = "select * from Promo";
        List<Promo> products = jdbcTemplateObject.query(SQL, new PromoMapper());
        return products;
    }

    @Override
    public Product createCart(Integer id, String img, String title, Integer price, Integer article, Integer qty) {
        String insertQuery = "insert into Cart (id, img, title, price, article, qty) values (?, ?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(insertQuery, id, img, title, price, article, qty);
        return null;
    }

    @Override
    public Product updateCart(Integer id, Integer qty) {
        String SQL = "update Cart set qty = ? where id = ?";
        jdbcTemplateObject.update(SQL, qty, id);
        return null;
    }

    @Override
    public Product deleteCart(Integer id) {
        String SQL = "delete from Cart where id = ?";
        jdbcTemplateObject.update(SQL, id);
        return null;
    }

    @Override
    public List<Product> getAllCart() {
        String SQL = "select * from Cart";
        List<Product> products = jdbcTemplateObject.query(SQL, new CartMapper());
        return products;
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