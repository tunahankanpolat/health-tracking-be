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
public class CreateAdminRequest {

    @NotBlank(message = "Name can not be blank")
    @NotNull(message = "Name is mandatory")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long")
    private String name;
    @NotBlank(message = "Surname can not be blank")
    @NotNull(message = "Surname is mandatory")
    @Size(min = 3, max = 20, message = "Surname must be between 3 and 20 characters long")
    private String surname;
    @NotBlank(message = "Username can not be blank")
    @NotNull(message = "Username is mandatory")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long")
    private String username;
    @NotBlank(message = "Password can not be blank")
    @NotNull(message = "Password is mandatory")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters long")
    private String password;
    private String phoneNumber;
    @Email(message = "Email address must be valid")
    private String emailAddress;
    private String address;

}