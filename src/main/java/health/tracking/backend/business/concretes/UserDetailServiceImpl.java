package health.tracking.backend.business.concretes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserDetailsService doctorService;
    private final UserDetailsService patientRelativeService;
    private final UserDetailsService patientService;
    private final UserDetailsService adminService;
    private final List<UserDetailsService> services;

    public UserDetailServiceImpl(
            @Qualifier("doctorServiceImpl") UserDetailsService doctorService,
            @Qualifier("patientRelativeServiceImpl") UserDetailsService patientRelativeService,
            @Qualifier("patientServiceImpl") UserDetailsService patientService,
            @Qualifier("adminServiceImpl") UserDetailsService adminService) {
        this.doctorService = doctorService;
        this.patientRelativeService = patientRelativeService;
        this.patientService = patientService;
        this.adminService = adminService;
        this.services = List.of(
                doctorService,
                patientRelativeService,
                patientService,
                adminService
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return services.stream()
                .map(s -> s.loadUserByUsername(username))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}

