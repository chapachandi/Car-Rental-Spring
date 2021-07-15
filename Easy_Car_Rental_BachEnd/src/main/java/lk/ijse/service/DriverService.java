package lk.ijse.service;

import lk.ijse.dto.DriverDTO;
import lk.ijse.dto.RegistrationDTO;

import java.util.ArrayList;

public interface DriverService {
    void addDriver(DriverDTO dto);

    void deleteDriver(String id);

    DriverDTO searchDriver(String id);

    ArrayList<DriverDTO> getAllDrivers();

    void updateDriver(DriverDTO dto);

//    DriverDTO findDEmailAndDPassword(String email, String password);

//    ArrayList<DriverDTO> findAllDriverNames(String name);

    DriverDTO findName(String dName);
}
