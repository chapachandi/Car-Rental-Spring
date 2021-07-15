package lk.ijse.repo;

import lk.ijse.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RegistrationRepo extends JpaRepository<Registration,String> {

    Optional<Registration> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    Optional<Registration> findByNic(String nic);

//    @Query("SELECT COUNT(reg) FROM Registration reg")
//    Long countRegistrations();

//    Long count(Registration registration);




}
