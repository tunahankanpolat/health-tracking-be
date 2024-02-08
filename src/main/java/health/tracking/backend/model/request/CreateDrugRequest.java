package health.tracking.backend.model.request;

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
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters long")
    private String name;
    @NotNull(message = "Instructions are mandatory")
    @Size(min = 3, max = 100, message = "Instructions must be between 3 and 100 characters long")
    private String instructions;
    @NotNull(message = "Description is mandatory")
    @Size(min = 3, max = 100, message = "Description must be between 3 and 100 characters long")
    private String description;
}
