package com.sharesquare.sharesquare.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Integer> {

    Optional<UserModel> findByEmail(String email);

    UserModel findByUserId(Integer userId);

    
}
