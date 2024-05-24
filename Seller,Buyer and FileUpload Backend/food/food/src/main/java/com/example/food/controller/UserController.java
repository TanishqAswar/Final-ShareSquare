package com.example.food.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.food.entity.User;
import com.example.food.entity.UserResponse;
import com.example.food.services.UserService;

@CrossOrigin("http://localhost:5173")
@RestController
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("/getAll")
	public List<UserResponse> getUsers() {
		return service.listAll().stream().map(this::convertToUserResponse).collect(Collectors.toList());
	}

	private UserResponse convertToUserResponse(User user) {
		String base64Image = Base64.getEncoder().encodeToString(user.getImage());
		return new UserResponse(
				user.getId(),
				user.getProductType(),
				user.getProductName(),
				user.getMonth(),
				user.getRentingCost(),
				user.getBuyingCost(),
				user.getDepositCost(),
				base64Image);
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestParam("buyingCost") Double buyingCost,
			@RequestParam("depositCost") Double depositCost,
			@RequestParam("image") MultipartFile image,
			@RequestParam("month") Integer month,
			@RequestParam("productName") String productName,
			@RequestParam("productType") String productType,
			@RequestParam("rentingCost") Double rentingCost) {
		if (!image.getContentType().startsWith("image/")) {
			throw new IllegalArgumentException("File must be an image");
		}
		try {
			User user = new User();
			user.setProductType(productType);
			user.setProductName(productName);
			user.setMonth(month);
			user.setRentingCost(rentingCost);
			user.setBuyingCost(buyingCost);
			user.setDepositCost(depositCost);
			user.setImage(image.getBytes());

			service.saveOrUpdate(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);

		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/user/{id}")
	private User getUser(@PathVariable(name = "id") int userId) {
		return service.getUserById(userId);
	}

	@PutMapping("/edit/{id}")
	private User update(@RequestBody User user, @PathVariable Long id) {
		user.setId(id);
		service.saveorUpdate(user);
		return user;
	}

	@DeleteMapping("/delete/{id}")
	private void deleteUser(@PathVariable("id") int id) {
		service.delete(id);
	}
}
