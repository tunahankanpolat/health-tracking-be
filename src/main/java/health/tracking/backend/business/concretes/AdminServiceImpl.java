package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.AdminService;
import health.tracking.backend.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
}
