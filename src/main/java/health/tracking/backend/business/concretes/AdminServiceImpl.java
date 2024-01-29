package health.tracking.backend.business.concretes;

import health.tracking.backend.model.Role;
import health.tracking.backend.model.entity.Admin;
import health.tracking.backend.business.abstracts.AdminService;
import health.tracking.backend.model.request.CreateAdminRequest;
import health.tracking.backend.model.request.UpdateAdminRequest;
import health.tracking.backend.model.response.GetAdminResponse;
import health.tracking.backend.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService, UserDetailsService {
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            admin.setAuthorities(Collections.singleton(Role.ADMIN));
        }
        return adminRepository.findByUsername(username);
    }
    public Admin getByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
    public String createAdmin(CreateAdminRequest request) {
        Admin newAdmin = Admin.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .address(request.getAddress())
                .emailAddress(request.getEmailAddress())
                .phoneNumber(request.getPhoneNumber())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();
        adminRepository.save(newAdmin);
        return "Admin created successfully";
    }

    @Override
    public GetAdminResponse getAdmin(Long id) {
        // Implement read logic
        // Find entity and convert to response
        return new GetAdminResponse();
    }

    @Override
    public String updateAdmin(UpdateAdminRequest request) {
        // Implement update logic
        // Update entity and convert to response
        return "Admin updated successfully";
    }

    @Override
    public String deleteAdmin(Long id) {
        // Implement delete logic
        adminRepository.deleteById(id);
        return "Admin deleted successfully";
    }
}
