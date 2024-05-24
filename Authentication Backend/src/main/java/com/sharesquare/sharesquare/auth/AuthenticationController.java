package com.sharesquare.sharesquare.auth;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharesquare.sharesquare.user.UserModel;
import com.sharesquare.sharesquare.user.UserRepository;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
     private final AuthenticationService service;
     private UserRepository userRepo;
        @CrossOrigin
        @PostMapping("/register")
        public ResponseEntity<String> register(@RequestBody Map<String, String> requestData) {
//        	UserModel user=this.userRepo.findByEmail()
            String user_handle = requestData.get("userHandle");
            String name = requestData.get("name");
            String email = requestData.get("email");
            String password = requestData.get("password");

            return ResponseEntity.ok(service.register(name, user_handle, email, password));
        }

     @CrossOrigin
     @PostMapping("/authenticate")
     public ResponseEntity<String> authenticate(
             @RequestBody Map<String, String> requestData) {
         String email = requestData.get("email");
         String password = requestData.get("password");
         return ResponseEntity.ok(service.authenticate(email, password));
     }
}


