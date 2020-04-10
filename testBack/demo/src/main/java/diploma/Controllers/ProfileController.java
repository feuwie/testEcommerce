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
import diploma.Model.User;
import diploma.Response.response;
import diploma.Services.ProductService;
import diploma.Services.ProfileService;
import diploma.Utilities.jwtUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProfileController {

    private ProfileService profileService;

    ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Autowired
    private jwtUtil jwtutil;

    @PostMapping("/profile")
    public ResponseEntity<response> getAddress(@RequestHeader(name = WebConstants.USER_AUTH_TOKEN) String AUTH_TOKEN) {
        System.out.println(AUTH_TOKEN);
        response resp = new response();
        if (jwtutil.checkToken(AUTH_TOKEN) != null) {
            try {
                System.out.println("Check there");
                System.out.println(AUTH_TOKEN);
                User user = jwtutil.checkToken(AUTH_TOKEN);
                System.out.println(user);
                // Address adr = addrRepo.findByUser(user);

                HashMap<String, String> map = new HashMap<>();
                // map.put(WebConstants.ADR_NAME, adr.getAddress());
                // map.put(WebConstants.ADR_CITY, adr.getCity());
                // map.put(WebConstants.ADR_STATE, adr.getState());
                // map.put(WebConstants.ADR_COUNTRY, adr.getCountry());
                // map.put(WebConstants.ADR_ZP, String.valueOf(adr.getZipcode()));
                // map.put(WebConstants.PHONE, adr.getPhonenumber());
                resp.setStatus(ResponseCode.SUCCESS_CODE);
                resp.setMessage(ResponseCode.CUST_ADR_ADD);
                resp.setUser(user);
                // resp.setMap(map);
                // resp.setAddress(adr);
                // resp.setAUTH_TOKEN(AUTH_TOKEN);
            } catch (Exception e) {
                resp.setStatus(ResponseCode.FAILURE_CODE);
                resp.setMessage(e.getMessage());
                resp.setAUTH_TOKEN(AUTH_TOKEN);
            }
        } else {
            resp.setStatus(ResponseCode.FAILURE_CODE);
            resp.setMessage(ResponseCode.FAILURE_MESSAGE);
        }
        return new ResponseEntity<response>(resp, HttpStatus.ACCEPTED);
    }
}