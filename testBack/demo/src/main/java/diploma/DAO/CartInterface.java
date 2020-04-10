package diploma.DAO;

import java.util.List;

import javax.sql.DataSource;

public interface CartInterface<T> {
    public void setDataSource(DataSource ds);

    public Object createCart(Integer id, String img, String title, Integer price, Integer article, Integer qty);

    public Object updateCart(Integer id, Integer qty);

    public Object deleteCart(Integer id);

    public List<T> getAllCart();
}