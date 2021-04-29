package cl.ionix.testbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cl.ionix.testbackend.model.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

	public User findByEmail(String email);
}
