package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.DoctorService;
import health.tracking.backend.model.Role;
import health.tracking.backend.model.entity.Doctor;
import health.tracking.backend.model.request.CreateDoctorRequest;
import health.tracking.backend.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService, UserDetailsService {
    private final DoctorRepository doctorRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorRepository.findByUsername(username);
        if (doctor != null) {
            doctor.setAuthorities(Collections.singleton(Role.DOCTOR));
        }
        return doctorRepository.findByUsername(username);
    }
    public Doctor getByUsername(String username) {
        return doctorRepository.findByUsername(username);
    }
    public String createDoctor(CreateDoctorRequest request) {
        Doctor newDoctor = Doctor.builder()
                .name(request.name())
                .surname(request.surname())
                .address(request.address())
                .emailAddress(request.emailAddress())
                .phoneNumber(request.phoneNumber())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .specialization(request.specialization())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();

        doctorRepository.save(newDoctor);
        return "Doctor created successfully";
    }
}
