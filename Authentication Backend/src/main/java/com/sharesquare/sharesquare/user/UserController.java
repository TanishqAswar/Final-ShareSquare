package com.sharesquare.sharesquare.user;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepo;

    @CrossOrigin
    @GetMapping("/getuser/{email}")
    public Optional<UserModel> getUserByEmail(@PathVariable String email) {
        return userRepo.findByEmail(email);
    }
}
