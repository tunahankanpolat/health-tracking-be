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
public class CreateDrugRequest {
    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long")
    private String name;
    @NotNull(message = "Instructions are mandatory")
    @NotBlank(message = "Instructions cannot be blank")
    @Size(min = 3, max = 10000, message = "Instructions must be between 3 and 10000 characters long")
    private String instructions;
    @NotNull(message = "Description is mandatory")
    @NotBlank(message = "Description cannot be blank")
    @Size(min = 3, max = 10000, message = "Description must be between 3 and 10000 characters long")
    private String description;
}
