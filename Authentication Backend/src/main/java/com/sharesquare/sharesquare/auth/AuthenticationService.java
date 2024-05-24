package com.sharesquare.sharesquare.auth;

import com.sharesquare.sharesquare.config.JwtService;
import com.sharesquare.sharesquare.user.Role;
import com.sharesquare.sharesquare.user.UserModel;
import com.sharesquare.sharesquare.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
   
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(String name, String userHandle, String email, String password) {
        UserModel user = UserModel.builder()
                .name(name)
                .user_handle(userHandle)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();
        repository.save(user);
        return "user is successfully signed up";
    }
    
    public String authenticate(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email, password));
        UserModel user = repository.findByEmail(email)
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return jwtToken;
    }

}
