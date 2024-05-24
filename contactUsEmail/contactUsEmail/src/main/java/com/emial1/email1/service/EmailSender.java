package com.emial1.email1.service;

public interface EmailSender {
	 void sendEmail(String to, String subject, String message,String messageByUser);
	 public void saveMessage(String name,String email, String message);
}
