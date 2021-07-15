package lk.ijse.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistrationDTO {
    private String email;
    private String password;
    private String nic;
    private String nicImage;
    private String dlicense;
    private String dlicenseImage;
    private String address;
    private int contactNo;
    private String cusStatus;

}
