package health.tracking.backend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPrescriptionResponse {
    private Long prescriptionId;
    private Date prescriptionDate;
    private Date expiryDate;
    private String instructions;
    private List<GetDrugUsageResponse> drugUsages;
}
