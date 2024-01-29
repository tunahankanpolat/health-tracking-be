package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.PrescriptionService;
import health.tracking.backend.model.request.CreatePrescriptionRequest;
import health.tracking.backend.model.request.UpdatePrescriptionRequest;
import health.tracking.backend.model.response.GetPrescriptionResponse;
import health.tracking.backend.repository.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;

    @Override
    public String createPrescription(CreatePrescriptionRequest request) {
        // Implement creation logic
        // Convert request to entity and save
        return "Prescription created successfully";  // Return response
    }

    @Override
    public GetPrescriptionResponse getPrescription(Long id) {
        // Implement read logic
        // Find entity and convert to response
        return new GetPrescriptionResponse();
    }

    @Override
    public String updatePrescription(UpdatePrescriptionRequest request) {
        // Implement update logic
        // Update entity and convert to response
        return "Prescription updated successfully";
    }

    @Override
    public String deletePrescription(Long id) {
        // Implement delete logic
        prescriptionRepository.deleteById(id);
        return "Prescription deleted successfully";
    }
}
