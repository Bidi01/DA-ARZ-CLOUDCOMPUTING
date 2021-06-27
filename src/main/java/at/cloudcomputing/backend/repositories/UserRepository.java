package at.cloudcomputing.backend.repositories;

import at.cloudcomputing.backend.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    Optional<User> findByEmail(String email);

}
