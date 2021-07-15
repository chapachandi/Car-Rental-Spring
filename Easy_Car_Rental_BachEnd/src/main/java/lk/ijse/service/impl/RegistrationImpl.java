package lk.ijse.service.impl;

import lk.ijse.dto.RegistrationDTO;
import lk.ijse.entity.Registration;
import lk.ijse.exception.NotFoundException;
import lk.ijse.exception.ValidateException;
import lk.ijse.repo.RegistrationRepo;
import lk.ijse.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
@Transactional

public class RegistrationImpl implements RegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;


    @Autowired
    private ModelMapper mapper;


    @Override
    public void addRegistration(RegistrationDTO dto) {
        if (registrationRepo.existsById(dto.getEmail())) {
            throw new ValidateException("Registrstion Already Exist");
        }
        System.out.println(dto.toString());
        registrationRepo.save(mapper.map(dto, Registration.class));
        System.out.println(mapper.map(dto, Registration.class).toString());

    }

    @Override
    public void deleteRegistration(String id) {
        if (!registrationRepo.existsById(id)) {
            throw new ValidateException("No Registration for Delete..!");
        }
        registrationRepo.deleteById(id);

    }

    @Override
    public RegistrationDTO searchRegistration(String id) {
        Optional<Registration> registration = registrationRepo.findById(id);
        if (registration.isPresent()) {
            return mapper.map(registration.get(), RegistrationDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<RegistrationDTO> getAllRegistrations() {

        List<Registration> all = registrationRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<RegistrationDTO>>() {
        }.getType());

    }

    @Override
    public void updateRegistration(RegistrationDTO dto) {

        if (registrationRepo.existsById(dto.getEmail())) {
            registrationRepo.save(mapper.map(dto, Registration.class));

        }
    }

    @Override
    public RegistrationDTO findEmailAndPassword(String email, String password) {
        Optional<Registration> reg = registrationRepo.findByEmailAndPassword(email, password);
        if (reg.isPresent()) {
            return mapper.map(reg.get(), RegistrationDTO.class);
        }
        throw new NotFoundException("Email name and Password Not Matched");
    }

    @Override
    public boolean findUser(String email) {
        boolean isAvailable = registrationRepo.existsByEmail(email);
        if (registrationRepo.existsById(email)) {
            registrationRepo.save(mapper.map(email, Registration.class));
            System.out.println(isAvailable+"");
            return true;
        }
        return false;

    }

    @Override
    public RegistrationDTO findNic(String nic) {
        Optional<Registration> registration = registrationRepo.findByNic(nic);
        if (registration.isPresent()) {
            return mapper.map(registration.get(), RegistrationDTO.class);
        }
        throw new NotFoundException("NIC Not Matched");
    }

//    @Override
//    public Long countUsers(RegistrationDTO registrationDTO) {
//       return registrationRepo.count((mapper.map(registrationDTO, Registration.class)));
//    }



}
