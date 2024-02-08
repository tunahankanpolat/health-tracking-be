package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.Prescription;
import health.tracking.backend.model.request.CreatePrescriptionRequest;
import health.tracking.backend.model.request.UpdatePrescriptionRequest;
import health.tracking.backend.model.response.GetPrescriptionResponse;

public interface PrescriptionService {
    String createPrescription(CreatePrescriptionRequest request);
    GetPrescriptionResponse getPrescription(Long id);
    String updatePrescription(UpdatePrescriptionRequest request);
    String deletePrescription(Long id);
    Prescription getPrescriptionById(Long id);
}
