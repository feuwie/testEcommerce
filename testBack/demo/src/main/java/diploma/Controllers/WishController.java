package diploma.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import diploma.Model.Product;
import diploma.Model.Wish;
import diploma.Services.WishService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WishController {

    private WishService wishService;

    WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @GetMapping("/wishlist")
    public List<Wish> getWishlist() {
        return wishService.getWishlistAll();
    }

    @PostMapping(path = "/addwishlist")
    public Wish addWishlist(@RequestBody Product product) {
        Integer id = product.getId();
        String img = product.getImg();
        String title = product.getTitle();
        Integer price = product.getPrice();
        Integer article = product.getArticle();
        return wishService.addWishlist(id, img, title, price, article);
    }

    @PostMapping(path = "/delwishlist")
    public Wish delWishlist(@RequestBody Product product) {
        Integer id = product.getId();
        return wishService.delWishlist(id);
    }
}