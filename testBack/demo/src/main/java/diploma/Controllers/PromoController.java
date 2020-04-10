package diploma.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import diploma.Model.Promo;
import diploma.Services.PromoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PromoController {

    private PromoService promoService;

    PromoController(PromoService promoService) {
        this.promoService = promoService;
    }

    @GetMapping("/promo")
    public List<Promo> getPromo() {
        return promoService.getPromoAll();
    }
}