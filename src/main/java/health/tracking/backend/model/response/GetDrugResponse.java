package health.tracking.backend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetDrugResponse {
    private Long id;
    private String name;
    private String instructions;
    private String description;
}
