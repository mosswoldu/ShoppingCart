package finalProject.repositories;

import finalProject.domain.Address;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByStateAddress(String stateAddress);

    Address findByCountry(String country);

}
