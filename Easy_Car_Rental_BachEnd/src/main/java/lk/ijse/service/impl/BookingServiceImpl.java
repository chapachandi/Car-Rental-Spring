package lk.ijse.service.impl;


import lk.ijse.dto.BookingDTO;
import lk.ijse.entity.Booking;
import lk.ijse.entity.Car;
import lk.ijse.exception.ValidateException;
import lk.ijse.repo.BookingRepo;
import lk.ijse.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void addBooking(BookingDTO dto) {
        if (bookingRepo.existsById(dto.getRequestNumber())){
            throw new ValidateException("Request Already Exist");
        }
        bookingRepo.save(mapper.map(dto, Booking.class));
    }

    @Override
    public void deleteBooking(String id) {
        if (!bookingRepo.existsById(id)) {
            throw new ValidateException("No Request for Delete..!");
        }
        bookingRepo.deleteById(id);


    }

    @Override
    public BookingDTO searchBooking(String id) {
        Optional<Booking> booking = bookingRepo.findById(id);
        if (booking.isPresent()) {
            return mapper.map(booking.get(), BookingDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<BookingDTO> getAllBookings() {
        List<Booking> all = bookingRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<BookingDTO>>() {
        }.getType());
    }

    @Override
    public void updateBooking(BookingDTO dto) {
        if (bookingRepo.existsById(dto.getNicNumber())) {
            bookingRepo.save(mapper.map(dto, Booking.class));

        }

    }

    @Override
    public Long countDate(Date rentStartDate, Date rentEndDate) {
        return null;
    }

    @Override
    public String getLastID() {
        String lastId = bookingRepo.getLastID();
        if (lastId != null) {
            String[] split = lastId.split("R");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "R00" + id;
            else if (id < 100) return "R0" + id;
            else return "R" + id;
        }else {
            return "R001";
        }
    }


}
