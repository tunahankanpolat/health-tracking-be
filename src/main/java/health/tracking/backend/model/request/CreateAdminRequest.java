package health.tracking.backend.model.request;

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
public class CreateAdminRequest {

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
    String phoneNumber;
    String emailAddress;
    String address;

}