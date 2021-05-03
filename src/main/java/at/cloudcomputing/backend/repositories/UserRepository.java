package at.cloudcomputing.backend.repositories;

import at.cloudcomputing.backend.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {


}
