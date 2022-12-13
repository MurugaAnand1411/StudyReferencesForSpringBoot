package rubix.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rubix.books.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
}
