package lk.ijse.repo;

import lk.ijse.entity.Car;
import lk.ijse.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepo extends JpaRepository <Car,String>{
    Optional<Car> findByBrand(String brand);


}
