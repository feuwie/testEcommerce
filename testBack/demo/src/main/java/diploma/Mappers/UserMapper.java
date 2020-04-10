package diploma.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import diploma.Model.User;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User product = new User();
        product.setEmail(rs.getString("email"));
        product.setPassword(rs.getString("password"));
        product.setUsertype(rs.getString("usertype"));
        return product;
    }
}