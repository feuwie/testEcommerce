package diploma.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diploma.Response.serverResp;

import javax.validation.Valid;

import diploma.Utilities.jwtUtil;
import diploma.Utilities.Validator;

import diploma.Model.User;
import diploma.Services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private jwtUtil jwtutil;

    @PostMapping("/login")
    public ResponseEntity<serverResp> verifyUser(@Valid @RequestBody Map<String, String> credential) {
        String email = "";
        String password = "";
        if (credential.containsKey("email")) {
            email = credential.get("email");
        }
        if (credential.containsKey("password")) {
            password = credential.get("password");
        }
        User loggedUser = userService.getUser(email, password, "customer");
        serverResp resp = new serverResp();
        if (loggedUser != null) {
            String jwtToken = jwtutil.createToken(email, password, "customer");
            resp.setStatus("200");
            resp.setMessage("SUCCESS");
            resp.setAUTH_TOKEN(jwtToken);
        } else {
            resp.setStatus("500");
            resp.setMessage("ERROR");
        }
        return new ResponseEntity<serverResp>(resp, HttpStatus.OK);
    }

    @PostMapping("/registration")
    public ResponseEntity<serverResp> addUser(@RequestBody User user) {
        serverResp resp = new serverResp();
        try {
            if (Validator.isUserEmpty(user)) {
                resp.setStatus("400");
                resp.setMessage("BAD_REQUEST");
            } else if (!Validator.isValidEmail(user.getEmail())) {
                resp.setStatus("400");
                resp.setMessage("BAD_REQUEST");
            } else {
                resp.setStatus("200");
                resp.setMessage("REGISTERED");
                User reg = userService.regUser(user);
                resp.setObject(reg);
            }
        } catch (Exception e) {
            resp.setStatus("500");
            resp.setMessage(e.getMessage());
        }
        return new ResponseEntity<serverResp>(resp, HttpStatus.ACCEPTED);
    }
}