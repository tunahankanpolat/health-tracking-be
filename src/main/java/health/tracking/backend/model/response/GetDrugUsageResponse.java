package health.tracking.backend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetDrugUsageResponse {
    private Long drugUsageId;
    private String drugName;
    private double dosage;
    private int frequency;
}
