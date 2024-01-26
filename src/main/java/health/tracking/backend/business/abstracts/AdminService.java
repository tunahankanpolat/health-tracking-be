package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.Admin;
import health.tracking.backend.model.request.CreateAdminRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface AdminService {
    String createAdmin(CreateAdminRequest request);
    Admin getByUsername(String username);
}
