package ProductReactSpring.northwind.Core.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import ProductReactSpring.northwind.Core.Entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	
	
}
