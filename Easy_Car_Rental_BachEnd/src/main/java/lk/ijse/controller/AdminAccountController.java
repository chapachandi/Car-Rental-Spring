package lk.ijse.controller;

import lk.ijse.dto.AdminAccountDTO;
import lk.ijse.dto.RegistrationDTO;
import lk.ijse.exception.NotFoundException;
import lk.ijse.service.AdminAccountService;
import lk.ijse.service.RegistrationService;
import lk.ijse.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/api/v1/adminaccount")
@CrossOrigin

public class AdminAccountController {

    @Autowired
    private AdminAccountService adminAccountSrevice;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveAdmin(@RequestBody AdminAccountDTO dto) throws ValidationException {
        if (dto.getUsername().trim().length() <= 0) {
            throw new NotFoundException("username cannot be empty");
        }
        adminAccountSrevice.addAdmin(dto);
        return new ResponseEntity(new StandradResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateAdmin(@RequestBody AdminAccountDTO dto) {
        if (dto.getUsername().trim().length() <= 0) {
            throw new NotFoundException("No username provided to update");
        }
        adminAccountSrevice.updateAdmin(dto);
        return new ResponseEntity(new StandradResponse("200", "Done", dto), HttpStatus.OK);
    }


}
