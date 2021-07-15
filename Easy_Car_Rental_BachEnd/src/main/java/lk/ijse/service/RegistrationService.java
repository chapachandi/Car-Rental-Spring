package lk.ijse.service;


import lk.ijse.dto.RegistrationDTO;

import java.util.ArrayList;

public interface RegistrationService {
    void addRegistration(RegistrationDTO dto);

    void deleteRegistration(String id);

    RegistrationDTO searchRegistration(String id);

    ArrayList<RegistrationDTO> getAllRegistrations();

    void updateRegistration(RegistrationDTO dto);

    RegistrationDTO findEmailAndPassword(String email, String password);

    boolean findUser(String email);

    RegistrationDTO findNic(String nic);

//    Long countUsers(RegistrationDTO registrationDTO);







}
