package diploma.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diploma.Response.serverResp;
import diploma.Utilities.jwtUtil;
import diploma.Model.User;
import diploma.Services.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Autowired
    private jwtUtil jwtutil;

    @PostMapping("/login")
    public ResponseEntity<serverResp> verifyUser(@RequestBody HashMap<String, String> credential) {
        String email = "";
        String password = "";
        if (credential.containsKey("email")) {
            email = credential.get("email");
        }
        if (credential.containsKey("password")) {
            password = credential.get("password");
        }
        User loggedUser = adminService.getUser(email, password, "admin");
        serverResp resp = new serverResp();
        if (loggedUser != null) {
            String jwtToken = jwtutil.createToken(email, password, "admin");
            resp.setStatus("200");
            resp.setMessage("SUCCESS");
            resp.setAUTH_TOKEN(jwtToken);
        } else {
            resp.setStatus("500");
            resp.setMessage("ERROR");
        }
        return new ResponseEntity<serverResp>(resp, HttpStatus.OK);
    }
}