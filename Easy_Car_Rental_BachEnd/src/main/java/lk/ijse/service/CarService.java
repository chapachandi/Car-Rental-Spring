package lk.ijse.service;

import lk.ijse.dto.CarDTO;
import lk.ijse.dto.DriverDTO;

import java.util.ArrayList;

public interface CarService {
    void addCar(CarDTO dto);

    void deleteCar(String id);

    CarDTO searchCar(String id);

    ArrayList<CarDTO> getAllCars();

    void updateCar(CarDTO dto);

//    DriverDTO findName(String dName);

    CarDTO findBrand(String brand);

}
