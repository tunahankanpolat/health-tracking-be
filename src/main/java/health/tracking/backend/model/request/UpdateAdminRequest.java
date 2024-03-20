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
public class UpdateAdminRequest {
    @NotNull(message = "Id is mandatory")
    @NotBlank(message = "Id can not be blank")
    private Long id;
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long")
    private String name;
    @Size(min = 3, max = 20, message = "Surname must be between 3 and 20 characters long")
    private String surname;
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters long")
    private String password;
    @NotNull(message = "Phone number is mandatory")
    @NotBlank(message = "Phone number can not be blank")
    @Size(min = 11, max = 11, message = "Phone number must be 11 characters long")
    private String phoneNumber;
    @NotBlank(message = "Email address can not be blank")
    @Email(message = "Email address must be valid")
    private String emailAddress;
    @NotBlank(message = "Address can not be blank")
    private String address;
}
