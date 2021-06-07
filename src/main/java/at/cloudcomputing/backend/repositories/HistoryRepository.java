package at.cloudcomputing.backend.repositories;

import at.cloudcomputing.backend.models.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Integer> {
}
