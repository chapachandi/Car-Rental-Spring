package lk.ijse.controller;

import lk.ijse.dto.CarDTO;
import lk.ijse.dto.RegistrationDTO;
import lk.ijse.exception.NotFoundException;
import lk.ijse.service.RegistrationService;
import lk.ijse.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.ValidationException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/regisration")
@CrossOrigin
public class RegistrationController {

    @Autowired
    private RegistrationService regSrevice;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveRegistration(@RequestBody RegistrationDTO dto) throws ValidationException {
        if (dto.getEmail().trim().length() <= 0) {
            throw new NotFoundException("email cannot be empty");
        }
        regSrevice.addRegistration(dto);
        return new ResponseEntity(new StandradResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllRegistrations() {
        ArrayList<RegistrationDTO> allRegistrations = regSrevice.getAllRegistrations();
        return new ResponseEntity(new StandradResponse("200", "Done", allRegistrations), HttpStatus.OK);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateRegistration(@RequestBody RegistrationDTO dto) {
        if (dto.getEmail().trim().length() <= 0) {
            throw new NotFoundException("No email provided to update");
        }
        regSrevice.updateRegistration(dto);
        return new ResponseEntity(new StandradResponse("200", "Done", dto), HttpStatus.OK);
    }

    @GetMapping(path = "/{nic}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findNic(@PathVariable String nic) {
        RegistrationDTO registrationDTO = regSrevice.findNic(nic);
        return new ResponseEntity(new StandradResponse("200", "Done", registrationDTO), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveFile(@RequestPart("myFile") MultipartFile myFile) {

        System.out.println(myFile.getOriginalFilename());

        try {
            // Let's get the project location
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            // Let's create a folder there for uploading purposes, if not exists
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();
            // It is time to transfer the file into the newly created dir
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

//    @GetMapping(path = "/email/{email}/{password}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public RegistrationDTO findEmailAndPassword(@PathVariable String email, @PathVariable String password) {
//        if (!email.equals("") && !password.equals("")) {
//            if (email.equals(password)) {
//                return regSrevice.findEmailAndPassword(email, password);
//            }
//        }
//        return null;
//    }


    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findEmailAndPassword(@RequestBody RegistrationDTO user) {
        if (!user.getEmail().equals("") && !user.getPassword().equals("")) {
            RegistrationDTO dto = regSrevice.findEmailAndPassword(user.getEmail(), user.getPassword());
            return new ResponseEntity(new StandradResponse("200", "done",dto), HttpStatus.OK);
        }
        throw new NotFoundException("Please Input User name And Password");
    }

//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity findUser(@RequestBody RegistrationDTO user) {
//        if (user.getEmail().trim().length() <= 0) {
//            throw new NotFoundException("No email");
//        }
//        regSrevice.findUser(user.getEmail());
//        return new ResponseEntity(new StandradResponse("200", "Done", user.getEmail()), HttpStatus.OK);
//    }
//




}
