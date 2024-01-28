package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.PatientRelativeService;
import health.tracking.backend.model.Role;
import health.tracking.backend.model.entity.Doctor;
import health.tracking.backend.model.entity.PatientRelative;
import health.tracking.backend.model.entity.PatientRelative;
import health.tracking.backend.model.request.CreatePatientRelativeRequest;
import health.tracking.backend.repository.PatientRelativeRepository;
import health.tracking.backend.repository.PatientRelativeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientRelativeServiceImpl implements PatientRelativeService, UserDetailsService {
    private final PatientRelativeRepository patientRelativeRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PatientRelative patientRelative = patientRelativeRepository.findByUsername(username);
        if (patientRelative != null) {
            patientRelative.setAuthorities(Collections.singleton(Role.PATIENT_RELATIVE));
        }
        return patientRelativeRepository.findByUsername(username);
    }
    public PatientRelative getByUsername(String username) {
        return patientRelativeRepository.findByUsername(username);
    }
    public String createPatientRelative(CreatePatientRelativeRequest request) {
        PatientRelative newPatientRelative = PatientRelative.builder()
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

        patientRelativeRepository.save(newPatientRelative);
        return "Patient Relative created successfully";
    }
}
