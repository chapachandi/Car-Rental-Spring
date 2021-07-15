package lk.ijse.controller;

import lk.ijse.dto.DriverDTO;
import lk.ijse.exception.NotFoundException;
import lk.ijse.service.DriverService;
import lk.ijse.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addDriver(@RequestBody DriverDTO dto) throws ValidationException {
        if (dto.getDriverId().length() <= 0) {
            throw new NotFoundException("Did cannot be empty");
        }
        driverService.addDriver(dto);
        return new ResponseEntity(new StandradResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllDrivers() {
        ArrayList<DriverDTO> allDrivers = driverService.getAllDrivers();
        return new ResponseEntity(new StandradResponse("200", "Done", allDrivers), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchDriver(@PathVariable String id) {
        DriverDTO driverDTO = driverService.searchDriver(id);
        return new ResponseEntity(new StandradResponse("200", "Done", driverDTO), HttpStatus.OK);
    }
    @GetMapping(path = "/name/{dName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findName(@PathVariable String dName) {
        DriverDTO driverDTO = driverService.findName(dName);
        return new ResponseEntity(new StandradResponse("200", "Done", driverDTO), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteDriver(@RequestParam String id) {
        driverService.deleteDriver(id);
        return new ResponseEntity(new StandradResponse("200", "Done", null), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDriver(@RequestBody DriverDTO dto) {
        if (dto.getDriverId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        driverService.updateDriver(dto);
        return new ResponseEntity(new StandradResponse("200", "Done", dto), HttpStatus.OK);
    }

//    @PostMapping(path = "/logindriver", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity findDEmailAndDPassword(@RequestBody DriverDTO user) {
//        if (!user.getD_email().equals("") && !user.getD_password().equals("")) {
//            DriverDTO dto = driverSrevice.findDEmailAndDPassword(user.getD_email(), user.getD_password());
//            return new ResponseEntity(new StandradResponse("200", "done",dto), HttpStatus.OK);
//        }
//        throw new NotFoundException("Please Input User name And Password");
//    }


//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity findAllDriverNames(@RequestBody DriverDTO dto) {
//        ArrayList<DriverDTO> allDriverNames = driverSrevice.findAllDriverNames(dto.getD_name());
//        return new ResponseEntity(new StandradResponse("200", "Done", allDriverNames), HttpStatus.OK);
//    }




}
