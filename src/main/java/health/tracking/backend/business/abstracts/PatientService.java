package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.Patient;
import health.tracking.backend.model.request.CreatePatientRequest;
import health.tracking.backend.model.request.UpdatePatientRequest;
import health.tracking.backend.model.response.GetPatientResponse;

public interface PatientService {
    String createPatient(CreatePatientRequest request);
    GetPatientResponse getPatient(Long id);
    String updatePatient(UpdatePatientRequest request);
    String deletePatient(Long id);
    Patient getByUsername(String username);
}
