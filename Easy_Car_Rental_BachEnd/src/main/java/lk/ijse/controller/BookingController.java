package lk.ijse.controller;

import lk.ijse.dto.BookingDTO;
import lk.ijse.dto.CarDTO;
import lk.ijse.exception.NotFoundException;
import lk.ijse.service.BookingService;
import lk.ijse.service.CarService;
import lk.ijse.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/booking")
@CrossOrigin

public class BookingController {
    @Autowired
    private BookingService bookingService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBooking(@RequestBody BookingDTO dto) throws ValidationException {
        if (dto.getNicNumber().trim().length() <= 0) {
            throw new NotFoundException("Nic number cannot be empty");
        }
        bookingService.addBooking(dto);
        return new ResponseEntity(new StandradResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCars() {
        ArrayList<BookingDTO> allBookings = bookingService.getAllBookings();
        return new ResponseEntity(new StandradResponse("200", "Done", allBookings), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchBooking(@PathVariable String id) {
        BookingDTO bookingDTO = bookingService.searchBooking(id);
        return new ResponseEntity(new StandradResponse("200", "Done", bookingDTO), HttpStatus.OK);
    }


    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteBooking(@RequestParam String id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity(new StandradResponse("200", "Done", null), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateBooking(@RequestBody BookingDTO dto) {
        if (dto.getNicNumber().trim().length() <= 0) {
            throw new NotFoundException("No nic number provided to update");
        }
        bookingService.updateBooking(dto);
        return new ResponseEntity(new StandradResponse("200", "Done", dto), HttpStatus.OK);
    }



}
