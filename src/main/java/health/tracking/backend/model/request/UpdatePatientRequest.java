package health.tracking.backend.model.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePatientRequest {
    @NotNull(message = "Id is mandatory")
    @NotBlank(message = "Id can not be blank")
    private Long id;
    @NotBlank(message = "Name can not be blank")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long")
    private String name;
    @NotBlank(message = "Surname can not be blank")
    @Size(min = 3, max = 20, message = "Surname must be between 3 and 20 characters long")
    private String surname;
    @NotBlank(message = "Password can not be blank")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters long")
    private String password;
    @NotBlank(message = "Phone number can not be blank")
    @Size(min = 10, max = 10, message = "Phone number must be 10 characters long")
    private String phoneNumber;
    @NotBlank(message = "Email address can not be blank")
    @Email(message = "Email address must be valid")
    private String emailAddress;
    @NotBlank(message = "Address can not be blank")
    private String address;


    @Past(message = "Birth date must be in the past")
    private Date birthDate;
    private String gender;
    private int height;
    private int weight;
    private String bloodType;
    private String rfidTag;

}
