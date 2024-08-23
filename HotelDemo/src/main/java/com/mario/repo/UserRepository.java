package com.mario.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mario.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	boolean  exsistsByEmail(String email);
	
	Optional<User> findByEmail(String email);

}
