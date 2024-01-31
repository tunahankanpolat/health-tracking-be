package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.AdminService;
import health.tracking.backend.model.Role;
import health.tracking.backend.model.entity.Admin;
import health.tracking.backend.model.entity.User;
import health.tracking.backend.model.request.CreateAdminRequest;
import health.tracking.backend.model.request.UpdateAdminRequest;
import health.tracking.backend.model.response.GetAdminResponse;
import health.tracking.backend.repository.AdminRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService, UserDetailsService {
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.getByUsername(username);
    }
    public Admin getByUsername(String username) {
        return adminRepository.findByUserUsername(username);
    }
    public String createAdmin(CreateAdminRequest request) {
        User user = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .address(request.getAddress())
                .emailAddress(request.getEmailAddress())
                .phoneNumber(request.getPhoneNumber())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .authorities(Collections.singleton(Role.ADMIN))
                .registrationDate(new Date())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();
        Admin newAdmin = Admin.builder()
                .user(user)
                .build();
        adminRepository.save(newAdmin);
        return "Admin created successfully";
    }

    @Override
    public GetAdminResponse getAdmin(Long id) {
        Admin admin = adminRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return GetAdminResponse.builder()
                .name(admin.getUser().getName())
                .surname(admin.getUser().getSurname())
                .username(admin.getUser().getUsername())
                .phoneNumber(admin.getUser().getPhoneNumber())
                .emailAddress(admin.getUser().getEmailAddress())
                .address(admin.getUser().getAddress())
                .build();
    }

    @Override
    public String updateAdmin(UpdateAdminRequest request) {
        Admin admin = adminRepository.findById(request.getId()).orElseThrow(EntityNotFoundException::new);

        return "Admin updated successfully";
    }

    @Override
    public String deleteAdmin(Long id) {
        // Implement delete logic
        adminRepository.deleteById(id);
        return "Admin deleted successfully";
    }
}
