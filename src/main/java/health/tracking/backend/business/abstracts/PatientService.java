package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.Patient;
import health.tracking.backend.model.request.CreateAdminRequest;
import health.tracking.backend.model.request.CreatePatientRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface PatientService {
    String createPatient(CreatePatientRequest request);
    Patient getByUsername(String username);
}
