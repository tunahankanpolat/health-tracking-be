package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.Admin;
import health.tracking.backend.model.request.CreateAdminRequest;
import health.tracking.backend.model.request.UpdateAdminRequest;
import health.tracking.backend.model.response.GetAdminResponse;

public interface AdminService {

    String createAdmin(CreateAdminRequest request);
    GetAdminResponse getAdmin(Long id);
    String updateAdmin(UpdateAdminRequest request);
    String deleteAdmin(Long id);

    Admin getByUsername(String username);
}
