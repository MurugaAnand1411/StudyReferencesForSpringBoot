package rubix.books.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import rubix.books.dto.UserRegistrationDto;
import rubix.books.entities.User;



public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}