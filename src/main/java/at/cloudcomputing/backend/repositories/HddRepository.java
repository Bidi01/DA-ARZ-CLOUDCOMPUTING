package at.cloudcomputing.backend.repositories;

import at.cloudcomputing.backend.models.Hdd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HddRepository extends JpaRepository<Hdd, Integer> {
}
