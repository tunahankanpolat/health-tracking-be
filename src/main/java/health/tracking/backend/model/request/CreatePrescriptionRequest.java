package health.tracking.backend.model.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "Patient ID is mandatory")
    private Long patientId;
    @FutureOrPresent(message = "Prescription date must be in the present or future")
    @NotNull(message = "Prescription date is mandatory")
    private Date prescriptionDate;
    @NotNull(message = "Expiry date is mandatory")
    @FutureOrPresent(message = "Expiry date must be in the present or future")
    private Date expiryDate;
    @NotNull(message = "Instructions are mandatory")
    @Size(min = 3, max = 1000, message = "Instructions must be between 3 and 1000 characters long")
    private String instructions;
    @NotNull(message = "Drug usages are mandatory")
    @Size(min = 1, message = "At least one drug usage must be provided")
    private List<CreateDrugUsageRequest> drugUsages;
}
