package at.cloudcomputing.backend.repositories;

import at.cloudcomputing.backend.models.Bestellungen;
import at.cloudcomputing.backend.models.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpuRepository extends JpaRepository<Cpu, Integer> {
}
