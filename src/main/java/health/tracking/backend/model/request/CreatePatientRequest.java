package health.tracking.backend.model.request;

import health.tracking.backend.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientRequest {
    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name is mandatory")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long")
    String name;
    @NotBlank(message = "Surname is mandatory")
    @NotNull(message = "Surname is mandatory")
    @Size(min = 3, max = 20, message = "Surname must be between 3 and 20 characters long")
    String surname;
    @NotBlank(message = "Username is mandatory")
    @NotNull(message = "Username is mandatory")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long")
    String username;
    @NotBlank(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters long")
    String password;
    @Past(message = "Birth date must be in the past")
    Date birthDate;
    String gender;
    int height;
    int weight;
    String bloodType;
    String rfidTag;
    @NotBlank(message = "Phone number is mandatory")
    @NotNull(message = "Phone number is mandatory")
    @Size(min = 3, max = 20, message = "Phone number must be between 3 and 20 characters long")
    String phoneNumber;
    String emailAddress;
    @NotBlank(message = "Address is mandatory")
    @NotNull(message = "Address is mandatory")
    @Size(min = 3, max = 200, message = "Address must be between 3 and 200 characters long")
    String address;
}