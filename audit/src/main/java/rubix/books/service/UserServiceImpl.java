package rubix.books.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import rubix.books.dto.UserRegistrationDto;
import rubix.books.entities.Role;
import rubix.books.entities.User;
import rubix.books.repository.RoleRepository;
import rubix.books.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{ 
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User();
		 user.setFirstName(registrationDto.getFirstName());
	        user.setLastName(registrationDto.getLastName());
	        user.setEmail(registrationDto.getEmail());
	        user.setMobileNumber(registrationDto.getMobileNumber());
	        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
	        System.out.println("Going to get the roles for the user now.....");
	        
	        Role role = roleRepository.findByName("ROLE_USER");
	      
	        user.setRoles(Arrays.asList(role));
	        return userRepository.save(user);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	

	

}
