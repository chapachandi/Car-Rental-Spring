package lk.ijse.service;

import lk.ijse.dto.BookingDTO;
import java.util.ArrayList;
import java.util.Date;


public interface BookingService {

    void addBooking(BookingDTO dto);

    void deleteBooking(String id);

    BookingDTO searchBooking(String id);

    ArrayList<BookingDTO> getAllBookings();

    void updateBooking(BookingDTO dto);

    Long countDate(Date rentStartDate, Date rentEndDate);

    String getLastID();
}
