package lk.ijse.dto;

import lk.ijse.entity.Car;
import lk.ijse.entity.Driver;
import lk.ijse.entity.Registration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDTO {

    private String requestNumber;
    private String nicNumber;
    private String brand;
    private String rate;
    private Date rentStartDate;
    private Date rentEndDate;
    private String drName;

    private Registration registration;
    private Car car;
    private Driver driver;


}
