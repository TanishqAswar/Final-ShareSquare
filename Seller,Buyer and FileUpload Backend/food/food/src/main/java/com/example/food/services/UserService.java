package com.example.food.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.food.entity.User;
import com.example.food.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public List<User> listAll() {
		return (List<User>) userRepo.findAll();
	}

	public void saveorUpdate(User user) {
		userRepo.save(user);
	}

	private static final int MAX_IMAGE_SIZE = 10 * 1024 * 1024;

	public void saveOrUpdate(User user) {
		if (user.getImage().length > MAX_IMAGE_SIZE) {
			throw new IllegalArgumentException("Image size exceeds the maximum allowed limit.");
		}
		userRepo.save(user);
	}

	public User getUserById(long id) {
		return userRepo.findById(id).orElse(null);
	}

	public void update(User user, int id) {
		userRepo.save(user);
	}

	public void delete(long id) {
		userRepo.deleteById(id);
	}
}
