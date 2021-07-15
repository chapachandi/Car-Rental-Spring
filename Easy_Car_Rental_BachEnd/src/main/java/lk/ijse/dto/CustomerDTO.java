package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String cusId;
    private String cusEmail;
    private String cusPassword;
    private String cusNic;
    private String cusNicImage;
    private String cusDriverLicense;
    private String cusDriverLicenseImage;
    private String cusAddress;
    private int cusContactNo;
    private String cusStatus;
}
