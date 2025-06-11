package com.example.axsos.services;

import java.util.Optional;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.axsos.models.User;
import com.example.axsos.models.LoginUser;
import com.example.axsos.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User Login(LoginUser userLogin, BindingResult bindingResult) {
		
		// Find user in the DB by email (بدل username)
		Optional<User> loginUser = userRepo.findByEmail(userLogin.getEmail());
		if (loginUser.isEmpty()) {
			bindingResult.rejectValue("email", "Not Found", "Email does not exist");
			return null;
		}
		
		User user = loginUser.get();
		
		// تحقق من كلمة السر
		if (!BCrypt.checkpw(userLogin.getPassword(), user.getPassword())) {
			bindingResult.rejectValue("password", "invalid", "Email or Password does not exist");
		}
		
		if (bindingResult.hasErrors()) {
			return null;
		} else {
			return user;
		}
	}
	
	public User register(User user, BindingResult bindingResult) {
		// تحقق من وجود الايميل مسبقاً
		if (userRepo.existsByEmail(user.getEmail())) {
			bindingResult.rejectValue("email", "Exists", "This Email already exists!");
		}
		
		// تحقق من تطابق كلمة السر
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			bindingResult.rejectValue("password", "Not.Match", "Passwords not match!");
		}
		
		if (bindingResult.hasErrors()) {
			return null;
		}
		
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);
		return userRepo.save(user);
	}
}
