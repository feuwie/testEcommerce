package diploma.DAO;

import java.util.List;

import javax.sql.DataSource;

import diploma.Model.Promo;

public interface ProductInterface<T> {
   public void setDataSource(DataSource ds);
   public Object createWishlist(Integer id, String img, String title, Integer price, Integer article);
   public Object deleteWishlist(Integer id);
   public List<Promo> getAllPromo();
   public List<T> getAllWishlist();
   public Object createCart(Integer id, String img, String title, Integer price, Integer article, Integer qty);
   public Object updateCart(Integer id, Integer qty);
   public Object deleteCart(Integer id);
   public List<T> getAllCart();
   public List<T> getAll();
   public List<T> getOneArticle(Integer article);
   public List<T> getOneParent(Integer parent);
   public List<T> getOneTitle(String title);
}