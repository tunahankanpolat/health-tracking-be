package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.PatientRelative;
import health.tracking.backend.model.request.CreatePatientRelativeRequest;
import health.tracking.backend.model.request.UpdatePatientRelativeRequest;
import health.tracking.backend.model.response.GetPatientRelativeResponse;

public interface PatientRelativeService {
    String createPatientRelative(CreatePatientRelativeRequest request);
    GetPatientRelativeResponse getPatientRelative(Long id);
    String updatePatientRelative(UpdatePatientRelativeRequest request);
    String deletePatientRelative(Long id);
    PatientRelative getByUsername(String username);
}
