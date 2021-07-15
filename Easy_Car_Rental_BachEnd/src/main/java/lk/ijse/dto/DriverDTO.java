package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DriverDTO {
    private String driverId;
    private String driverName;
    private String driverEmail;
    private String driverPassword;
    private String driverNic;
    private String driverLicense;
    private String driverAddress;
    private int driverContactNo;
    private int driverAge;
    private String driverGender;
}
