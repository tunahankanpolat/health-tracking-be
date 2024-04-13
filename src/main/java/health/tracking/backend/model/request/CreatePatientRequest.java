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
public class CreatePatientRequest {
    private String name;
    @NotNull(message = "Surname is mandatory")
    @Size(min = 3, max = 20, message = "Surname must be between 3 and 20 characters long")
    private String surname;
    @NotNull(message = "Username is mandatory")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long")
    private String username;
    @NotNull(message = "Password is mandatory")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters long")
    private String password;
    @Past(message = "Birth date must be in the past")
    private Date birthDate;
    private String gender;
    private int height;
    private int weight;
    private String bloodType;
    private String rfidTag;
    @NotNull(message = "Phone number is mandatory")
    @NotBlank(message = "Phone number can not be blank")
    @Size(min = 11, max = 11, message = "Phone number must be 11 characters long")
    private String phoneNumber;
    @Email(message = "Email address must be valid")
    private String emailAddress;
    @NotBlank(message = "Address can not be blank")
    @NotNull(message = "Address is mandatory")
    @Size(min = 3, max = 200, message = "Address must be between 3 and 200 characters long")
    private String address;
}