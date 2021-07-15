package lk.ijse.service.impl;

import lk.ijse.dto.DriverDTO;
import lk.ijse.dto.RegistrationDTO;
import lk.ijse.entity.Driver;
import lk.ijse.entity.Registration;
import lk.ijse.exception.NotFoundException;
import lk.ijse.exception.ValidateException;
import lk.ijse.repo.DriverRepo;
import lk.ijse.repo.RegistrationRepo;
import lk.ijse.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;



    @Override
    public void addDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDriverId())) {
            throw new ValidateException("Driver Already Exist");
        }
        System.out.println(dto.toString());
        driverRepo.save(mapper.map(dto, Driver.class));
        System.out.println(mapper.map(dto, Driver.class).toString());


    }

    @Override
    public void deleteDriver(String id) {
        if (!driverRepo.existsById(id)) {
            throw new ValidateException("No Driver for Delete..!");
        }
        driverRepo.deleteById(id);


    }

    @Override
    public DriverDTO searchDriver(String id) {
        Optional<Driver> driver = driverRepo.findById(id);
        if (driver.isPresent()) {
            return mapper.map(driver.get(), DriverDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        List<Driver> all = driverRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDriverId())) {
            driverRepo.save(mapper.map(dto, Driver.class));

        }

    }

    @Override
    public DriverDTO findName(String dName) {
        Optional<Driver> driver = driverRepo.findByDriverName(dName);
        if (driver.isPresent()) {
            return mapper.map(driver.get(), DriverDTO.class);
        }
        return null;
    }

//    @Override
//    public DriverDTO findDEmailAndDPassword(String email, String password) {
//                Optional<Driver> reg = driverRepo.findByD_emailAndD_password(email, password);
//        if (reg.isPresent()) {
//            return mapper.map(reg.get(), DriverDTO.class);
//        }
//        throw new NotFoundException("Email name and Password Not Matched");
//    }



//    @Override
//    public ArrayList<DriverDTO> findAllDriverNames(String name) {
//        List<Driver> allNames = driverRepo.readDriverByD_name(name);
//        return mapper.map(allNames, new TypeToken<ArrayList<DriverDTO>>() {
//        }.getType());
//    }
}
