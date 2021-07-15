package lk.ijse.repo;

import lk.ijse.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface BookingRepo extends JpaRepository<Booking,String> {
    @Query(value = "select datediff(rentStartDate,rentEndDate)", nativeQuery = true)
    Long countByRentStartDateAndRentEndDate(Date rentStartDate, Date rentEndDate );

    @Query(value="SELECT requestNumber FROM booking ORDER BY requestNumber DESC LIMIT 1",nativeQuery = true)
    String getLastID();

}
