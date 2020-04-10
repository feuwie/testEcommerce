package diploma.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import diploma.Model.Wish;

public class WishMapper implements RowMapper<Wish> {
     public Wish mapRow(ResultSet rs, int rowNum) throws SQLException {
          Wish product = new Wish();
          product.setId(rs.getInt("id"));
          product.setImg(rs.getString("img"));
          product.setTitle(rs.getString("title"));
          product.setPrice(rs.getInt("price"));
          product.setArticle(rs.getInt("article"));
          return product;
     }
}