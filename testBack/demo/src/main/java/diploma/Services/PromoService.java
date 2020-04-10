package diploma.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import diploma.Entity.PromoDAO;
import diploma.Model.Promo;

import java.util.List;

@Component
public class PromoService {

    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    PromoDAO promoDAO = (PromoDAO) context.getBean("promoJDBC");

    public List<Promo> getPromoAll() {
        List<Promo> result = promoDAO.getAllPromo();
        return result;
    }
}