package diploma.Entity;

import diploma.DAO.PromoInterface;
import diploma.Mappers.PromoMapper;
import diploma.Model.Promo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import javax.sql.DataSource;

@Component
public class PromoDAO implements PromoInterface<Promo> {
    public DataSource dataSource;
    public JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Promo> getAllPromo() {
        String SQL = "select * from Promo";
        List<Promo> result = jdbcTemplateObject.query(SQL, new PromoMapper());
        return result;
    }
}