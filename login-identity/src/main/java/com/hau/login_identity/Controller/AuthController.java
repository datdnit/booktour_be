package com.hau.login_identity.Controller;

import com.hau.login_identity.Model.User;
import com.hau.login_identity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        Optional<User> user = userService.login(username, password);
        if (user.isPresent()) {
            return ResponseEntity.ok("da dang nhap thanh cong, xin chao " + user.get().getUsername());
        } else {
            return ResponseEntity.status(401).body("Sai mat khau hoac ten dang nhap");
        }
    }
}
