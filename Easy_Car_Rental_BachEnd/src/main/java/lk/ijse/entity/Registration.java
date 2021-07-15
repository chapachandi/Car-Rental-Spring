package lk.ijse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Registration {

    @Id
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
