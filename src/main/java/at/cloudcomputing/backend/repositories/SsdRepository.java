package at.cloudcomputing.backend.repositories;

import at.cloudcomputing.backend.models.Ssd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SsdRepository extends JpaRepository<Ssd, Integer> {
}
