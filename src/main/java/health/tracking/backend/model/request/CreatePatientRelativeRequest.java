package health.tracking.backend.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientRelativeRequest {
    @NotNull(message = "Name is mandatory")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long")
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
    @Size(min = 3, max = 20, message = "Relationship must be between 3 and 20 characters long")
    private String relationship;
}