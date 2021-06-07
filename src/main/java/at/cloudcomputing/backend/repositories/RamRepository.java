package at.cloudcomputing.backend.repositories;

import at.cloudcomputing.backend.models.Ram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RamRepository extends JpaRepository<Ram, Integer> {
}
