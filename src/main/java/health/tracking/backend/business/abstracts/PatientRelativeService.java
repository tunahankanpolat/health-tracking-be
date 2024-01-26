package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.PatientRelative;
import health.tracking.backend.model.request.CreateAdminRequest;
import health.tracking.backend.model.request.CreatePatientRelativeRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface PatientRelativeService {
    String createPatientRelative(CreatePatientRelativeRequest request);
    PatientRelative getByUsername(String username);
}
