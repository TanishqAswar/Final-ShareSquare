package com.emial1.email1.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.emial1.email1.Model.UserMessage;
import com.emial1.email1.repo.userRepo;


@Service
public class EmailSenderImpl implements EmailSender {

	
	public  userRepo userRepo1;
    private final JavaMailSender mailSender;
  
    public EmailSenderImpl(JavaMailSender mailSender,userRepo userRepo1) {
    	this.userRepo1 = userRepo1;
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String message, String messageByUser) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("tanishqaswar2005@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        this.mailSender.send(simpleMailMessage);
        SimpleMailMessage simpleMailMessage1 = new SimpleMailMessage();
        
        simpleMailMessage1.setFrom("tanishqaswar2005@gmail.com");
        simpleMailMessage1.setTo("aditya.gunjkar04@gmail.com");
        simpleMailMessage1.setSubject("Query of Customer "+to);
        simpleMailMessage1.setText("Hello Agent\n"+"Query of Customer "+ to+" is :\n"+messageByUser);
        this.mailSender.send(simpleMailMessage1);
    }
    
    public void saveMessage(String name,String email, String message) {
    	  UserMessage userMessage = new UserMessage();
          userMessage.setName(name);
          userMessage.setEmail(email);
          userMessage.setMessage(message);

          // Save the entity to the database using Spring Data JPA's save() method
          userRepo1.save(userMessage);
    }
}

