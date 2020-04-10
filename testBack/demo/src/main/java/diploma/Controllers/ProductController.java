package diploma.Controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import diploma.Constants.ResponseCode;
import diploma.Constants.WebConstants;
import diploma.Model.Product;
import diploma.Services.ProductService;
import diploma.Utilities.jwtUtil;
// import diploma.Response.response;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
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
        return productService.getProductTitle(title);
    }
}