package com.emial1.email1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserMessage {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private Long id;
	 	
		String Name;
		String Email;
		String Message;
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	
	

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public UserMessage(String message,String name,String email) {
		
		Message = message;
		Name=name;
		Email=email;
	}
	public UserMessage() {
		
	}
	
}
