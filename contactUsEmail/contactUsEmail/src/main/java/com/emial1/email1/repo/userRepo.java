package com.emial1.email1.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emial1.email1.Model.UserMessage;

public interface userRepo extends JpaRepository<UserMessage,Long>{

	
	
}
