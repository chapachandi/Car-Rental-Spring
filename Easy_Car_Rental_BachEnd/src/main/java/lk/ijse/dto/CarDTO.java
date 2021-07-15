package lk.ijse.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {
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
