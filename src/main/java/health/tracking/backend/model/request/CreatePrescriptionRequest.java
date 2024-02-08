package health.tracking.backend.model.request;

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
public class CreatePrescriptionRequest {
    private Long patientId;
    private Long doctorId;
    private Date prescriptionDate;
    private Date expiryDate;
    private String instructions;
    private List<CreateDrugUsageRequest> drugUsages;
}
