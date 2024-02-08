package health.tracking.backend.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDrugUsageRequest {
    private Long drugId;
    private double dosage;
    private int frequency;
}
