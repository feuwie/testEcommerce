package diploma.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import diploma.Model.Product;
import diploma.Model.Promo;
import diploma.Services.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }
    

    @GetMapping("/promo")
    public List<Promo> getPromo() {
        return productService.getPromoAll();
    }

    @GetMapping("/cart")
    public List<Product> getCart() {
        return productService.getCartAll();
    }

    @PostMapping(path = "/addcart")
    public Product addCart(@RequestBody Product product) {
        Integer id = product.getId();
        String img = product.getImg();
        String title = product.getTitle();
        Integer price = product.getPrice();
        Integer article = product.getArticle();
        Integer qty = product.getQty();
        // String about = product.getAbout();
        // Integer parent_id = product.getParent();
        return productService.addCart(id, img, title, price, article, qty);
    }

    @PostMapping(path = "/delcart")
    public Product delCart(@RequestBody Product product) {
        Integer id = product.getId();
        return productService.delCart(id);
    }

    @PostMapping(path = "/updatecart")
    public Product updCart(@RequestBody Product product) {
        Integer id = product.getId();
        Integer qty = product.getQty();
        return productService.updCart(id, qty);
    }

    @GetMapping("/wishlist")
    public List<Product> getWishlist() {
        return productService.getWishlistAll();
    }

    @PostMapping(path = "/addwishlist")
    public Product addWishlist(@RequestBody Product product) {
        Integer id = product.getId();
        String img = product.getImg();
        String title = product.getTitle();
        Integer price = product.getPrice();
        Integer article = product.getArticle();
        // String about = product.getAbout();
        // Integer parent_id = product.getParent();
        return productService.addWishlist(id, img, title, price, article);
    }

    @PostMapping(path = "/delwishlist")
    public Product delWishlist(@RequestBody Product product) {
        Integer id = product.getId();
        return productService.delWishlist(id);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        System.out.println(productService.getProductAll());
        return productService.getProductAll();
    }

    @PostMapping(path = "/{article}")
    public List<Product> postProductsArticle(@RequestBody Product product) {
        Integer article = product.getArticle();
        return productService.getProductAricle(article);
    }

    @PostMapping(path = "/{parent}")
    public List<Product> postProductsParent(@RequestBody Product product) {
        Integer parent = product.getParent();
        return productService.getProductParent(parent);
    }

    @PostMapping(path = "/{title}")
    public List<Product> postProductsTitle(@RequestBody Product product) {
        String title = product.getTitle();
        System.out.println(productService.getProductTitle(title));
        return productService.getProductTitle(title);
    }
}