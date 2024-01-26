package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.PatientService;
import health.tracking.backend.core.utils.jwt.JwtUtils;
import health.tracking.backend.model.Role;
import health.tracking.backend.model.entity.Doctor;
import health.tracking.backend.model.entity.Patient;
import health.tracking.backend.model.entity.Patient;
import health.tracking.backend.model.request.AuthRequest;
import health.tracking.backend.model.request.CreatePatientRequest;
import health.tracking.backend.repository.PatientRepository;
import health.tracking.backend.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService, UserDetailsService {
    private final PatientRepository patientRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByUsername(username);
        if (patient != null) {
            patient.setAuthorities(Collections.singleton(Role.PATIENT));
        }
        return patientRepository.findByUsername(username);
    }
    public Patient getByUsername(String username) {
        return patientRepository.findByUsername(username);
    }
    public String createPatient(CreatePatientRequest request) {
        Patient newPatient = Patient.builder()
                .name(request.name())
                .surname(request.surname())
                .address(request.address())
                .emailAddress(request.emailAddress())
                .phoneNumber(request.phoneNumber())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .bloodType(request.bloodType())
                .rfidTag(request.rfidTag())
                .height(request.height())
                .weight(request.weight())
                .gender(request.gender())
                .birthDate(request.birthDate())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();

        patientRepository.save(newPatient);
        return "Patient Relative created successfully";
    }
}
