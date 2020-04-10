package diploma.Controllers;

import java.io.IOException;
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

import diploma.Constants.WebConstants;
import diploma.Constants.ResponseCode;
import diploma.Response.cartResp;

import diploma.Model.Cart;
import diploma.Services.CartService;
import diploma.Utilities.Validator;
import diploma.Utilities.jwtUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CartController {

    private CartService cartService;

    CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @Autowired
    private jwtUtil jwtutil;

    @GetMapping("/cart")
    public ResponseEntity<cartResp> viewCart(@RequestHeader(name = WebConstants.USER_AUTH_TOKEN) String AUTH_TOKEN)
            throws IOException {
        cartResp resp = new cartResp();
        if (!Validator.isStringEmpty(AUTH_TOKEN) && jwtutil.checkToken(AUTH_TOKEN) != null) {
            try {
                System.out.println(AUTH_TOKEN);
                System.out.println("There 1");
                // User loggedUser = jwtutil.checkToken(AUTH_TOKEN);
                resp.setStatus(ResponseCode.SUCCESS_CODE);
                resp.setMessage(ResponseCode.VW_CART_MESSAGE);
                resp.setAUTH_TOKEN(AUTH_TOKEN);
                // resp.setOblist(cartRepo.findByEmail(loggedUser.getEmail()));
            } catch (Exception e) {
                System.out.println(AUTH_TOKEN);
                System.out.println("There 2");
                resp.setStatus(ResponseCode.FAILURE_CODE);
                resp.setMessage(e.getMessage());
                resp.setAUTH_TOKEN(AUTH_TOKEN);
            }
        } else {
            System.out.println(AUTH_TOKEN);
            System.out.println("There 3");
            resp.setStatus(ResponseCode.FAILURE_CODE);
            resp.setMessage(ResponseCode.FAILURE_MESSAGE);
        }
        return new ResponseEntity<cartResp>(resp, HttpStatus.ACCEPTED);
    }

    // @GetMapping("/cart")
    // public List<Cart> getCart() {
    // return cartService.getCartAll();
    // }

    @PostMapping(path = "/addcart")
    public Cart addCart(@RequestBody Cart product) {
        Integer id = product.getId();
        String img = product.getImg();
        String title = product.getTitle();
        Integer price = product.getPrice();
        Integer article = product.getArticle();
        Integer qty = product.getQty();
        return cartService.addCart(id, img, title, price, article, qty);
    }

    @PostMapping(path = "/delcart")
    public Cart delCart(@RequestBody Cart product) {
        Integer id = product.getId();
        return cartService.delCart(id);
    }

    @PostMapping(path = "/updatecart")
    public Cart updCart(@RequestBody Cart product) {
        Integer id = product.getId();
        Integer qty = product.getQty();
        return cartService.updCart(id, qty);
    }
}