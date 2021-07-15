package lk.ijse.repo;

import lk.ijse.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepo extends JpaRepository<Driver,String> {

    Optional<Driver> readByDriverEmailAndDriverPassword(String driverEmail, String driverPassword);

    List<Driver> readDriverByDriverName(String driverName);

    Optional<Driver> findByDriverName(String driverName);

    Optional<Driver> getDriverByDriverName(String driverName);

}
