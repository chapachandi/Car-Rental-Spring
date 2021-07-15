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
public class Car {
    @Id
    private String carNumber;
    private String brand;
    private String type;
    private int passengers;
    private String transmission;
    private String fuel;
    private double dailyRate;
    private double monthlyRate;
    private int freeKmForDay;
    private int freeKmForMonth;
    private double pricePerExtraKm;
    private String regNumber;
    private String color;
    private String file;
    private int carQuantity;


}
