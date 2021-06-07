package at.cloudcomputing.backend.repositories;

import at.cloudcomputing.backend.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
