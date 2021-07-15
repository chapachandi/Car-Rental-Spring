package lk.ijse.service.impl;

import lk.ijse.dto.CarDTO;
import lk.ijse.dto.DriverDTO;
import lk.ijse.entity.Car;
import lk.ijse.entity.Driver;
import lk.ijse.exception.ValidateException;
import lk.ijse.repo.CarRepo;
import lk.ijse.service.CarService;
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
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addCar(CarDTO dto){
        if (carRepo.existsById(dto.getCarNumber())){
           throw new ValidateException("Car Already Exist");
        }
        carRepo.save(mapper.map(dto, Car.class));
//        return false;
    }

    @Override
    public void deleteCar(String id) {
        if (!carRepo.existsById(id)) {
            throw new ValidateException("No Car for Delete..!");
        }
        carRepo.deleteById(id);

    }

    @Override
    public CarDTO searchCar(String id) {
        Optional<Car> car = carRepo.findById(id);
        if (car.isPresent()) {
            return mapper.map(car.get(), CarDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        List<Car> all = carRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (carRepo.existsById(dto.getCarNumber())) {
            carRepo.save(mapper.map(dto, Car.class));

        }

    }

    @Override
    public CarDTO findBrand(String brand) {
        Optional<Car> carBrand = carRepo.findByBrand(brand);
        if (carBrand.isPresent()) {
            return mapper.map(carBrand.get(), CarDTO.class);
        }
        return null;
    }
}
