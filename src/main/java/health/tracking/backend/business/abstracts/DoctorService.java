package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.Doctor;
import health.tracking.backend.model.request.CreateDoctorRequest;
import health.tracking.backend.model.request.UpdateDoctorRequest;
import health.tracking.backend.model.response.GetDoctorResponse;

public interface DoctorService {
    String createDoctor(CreateDoctorRequest request);
    GetDoctorResponse getDoctor(Long id);
    String updateDoctor(UpdateDoctorRequest request);
    String deleteDoctor(Long id);
    Doctor getByUsername(String username);
    Doctor getByDoctorById(Long id);
}
