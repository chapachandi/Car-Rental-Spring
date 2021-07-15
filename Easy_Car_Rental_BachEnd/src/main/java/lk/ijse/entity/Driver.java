package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Driver {
    @Id
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
