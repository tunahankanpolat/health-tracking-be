package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.Doctor;
import health.tracking.backend.model.request.CreateAdminRequest;
import health.tracking.backend.model.request.CreateDoctorRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface DoctorService {
    String createDoctor(CreateDoctorRequest request);
    Doctor getByUsername(String username);
}
