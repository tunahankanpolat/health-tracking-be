package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.Patient;
import health.tracking.backend.model.request.CreatePatientRequest;
import health.tracking.backend.model.request.UpdatePatientRequest;
import health.tracking.backend.model.response.GetDrugUsageResponse;
import health.tracking.backend.model.response.GetPatientResponse;
import health.tracking.backend.model.response.GetPrescriptionResponse;

import java.util.List;

public interface PatientService {
    String createPatient(CreatePatientRequest request, Long doctorId);
    GetPatientResponse getPatient(Long id);
    String updatePatient(UpdatePatientRequest request);
    String deletePatient(Long id);
    Patient getByUsername(String username);
    Patient getByPatientById(Long id);
    List<GetPatientResponse> getPatients();
    List<GetPrescriptionResponse> getPatientPrescriptions(Long id);

    List<GetDrugUsageResponse> getPatientDrugUsages(Long id);
}
