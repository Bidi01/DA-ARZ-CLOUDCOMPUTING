package at.cloudcomputing.backend.repositories;

import at.cloudcomputing.backend.models.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Integer> {

}
