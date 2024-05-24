package com.emial1.email1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emial1.email1.Model.EmailMessage;
import com.emial1.email1.Model.UserMessage;
import com.emial1.email1.service.EmailSender;

@RestController
@CrossOrigin
public class EmailController {

  
	private final EmailSender emailSenderService;
    
    public EmailController(EmailSender emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send-email")
    public ResponseEntity  sendEmail(@RequestBody  EmailMessage emailMessage) {
    	String userMessage1=emailMessage.getMessage();
    	String userTo=emailMessage.getTo();
    	
    	emailMessage.setMessage("Dear Customer,\n\n" +
    		    "Thank you for reaching out to ShareShare, your one-stop platform for everything rental! We are excited to connect with you and appreciate your interest in our services.\n\n" +
    		    "At ShareShare, we are committed to making the rental process simple and convenient. Whether you're looking to rent out your items or find something specific to rent, we have a wide range of options to meet your needs. Our goal is to provide you with an exceptional experience every time you use our platform.\n\n" +
    		    "If you have any questions or need assistance, please don't hesitate to contact us. Our customer support team is here to help and can be reached through this email. We strive to respond to all inquiries within 24 hours to ensure you receive timely support.\n\n" +
    		    "Thank you once again for choosing ShareShare. We look forward to serving you and making your rental experience seamless and enjoyable.\n\n" +
    		    "Best regards,\n\n" +
    		    
    		    "ShareShare"
    		);
    	emailMessage.setSubject("Thank You for Reaching Out to ShareShare!");
    	
        this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage(),userMessage1);
        this.emailSenderService.saveMessage(emailMessage.getName(), userTo, userMessage1);
        return ResponseEntity.ok("Success");
    }
}
