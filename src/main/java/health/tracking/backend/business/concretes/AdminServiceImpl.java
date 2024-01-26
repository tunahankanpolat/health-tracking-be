package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.AdminService;
import health.tracking.backend.model.Role;
import health.tracking.backend.model.entity.Admin;
import health.tracking.backend.model.entity.Doctor;
import health.tracking.backend.model.request.CreateAdminRequest;
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
                .name(request.name())
                .surname(request.surname())
                .address(request.address())
                .emailAddress(request.emailAddress())
                .phoneNumber(request.phoneNumber())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();
        adminRepository.save(newAdmin);
        return "Admin created successfully";
    }
}
