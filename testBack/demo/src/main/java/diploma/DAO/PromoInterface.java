package diploma.DAO;

import java.util.List;

import javax.sql.DataSource;

import diploma.Model.Promo;

public interface PromoInterface<T> {
    public void setDataSource(DataSource ds);

    public List<Promo> getAllPromo();
}