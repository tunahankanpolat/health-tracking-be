package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.Prescription;
import health.tracking.backend.model.request.CreatePrescriptionRequest;
import health.tracking.backend.model.request.UpdatePrescriptionRequest;

public interface PrescriptionService {
    String createPrescription(CreatePrescriptionRequest request, Long doctorId);
    String updatePrescription(UpdatePrescriptionRequest request);
    String deletePrescription(Long id);
    Prescription getPrescriptionById(Long id);
}
