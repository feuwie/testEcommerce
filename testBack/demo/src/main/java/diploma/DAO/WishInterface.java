package diploma.DAO;

import java.util.List;

import javax.sql.DataSource;

public interface WishInterface<T> {
    public void setDataSource(DataSource ds);

    public Object createWishlist(Integer id, String img, String title, Integer price, Integer article);

    public Object deleteWishlist(Integer id);

    public List<T> getAllWishlist();
}