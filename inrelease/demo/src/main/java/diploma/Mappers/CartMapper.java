package diploma.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import diploma.Model.Product;

public class CartMapper implements RowMapper<Product> {
     public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
          Product product = new Product();
          product.setId(rs.getInt("id"));
          product.setImg(rs.getString("img"));
          product.setTitle(rs.getString("title"));
          product.setPrice(rs.getInt("price"));
          product.setArticle(rs.getInt("article"));
          product.setQty(rs.getInt("qty"));
          // product.setAbout(rs.getString("about"));
          return product;
     }
}