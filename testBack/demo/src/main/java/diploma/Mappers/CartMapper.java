package diploma.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import diploma.Model.Cart;

public class CartMapper implements RowMapper<Cart> {
     public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
          Cart product = new Cart();
          product.setId(rs.getInt("id"));
          product.setImg(rs.getString("img"));
          product.setTitle(rs.getString("title"));
          product.setPrice(rs.getInt("price"));
          product.setArticle(rs.getInt("article"));
          // product.setAbout(rs.getString("about"));
          // product.setParent(rs.getInt("parent_id"));
          return product;
     }
}