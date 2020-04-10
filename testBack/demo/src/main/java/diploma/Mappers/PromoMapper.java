package diploma.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import diploma.Model.Promo;

public class PromoMapper implements RowMapper<Promo> {
    public Promo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Promo promo = new Promo();
        promo.setId(rs.getInt("id"));
        promo.setCode(rs.getString("txtCode"));
        promo.setType(rs.getString("codeType"));
        promo.setValue(rs.getInt("codeValue"));
        return promo;
    }
}