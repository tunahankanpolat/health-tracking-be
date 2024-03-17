package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.PatientRelativeService;
import health.tracking.backend.business.abstracts.PatientService;
import health.tracking.backend.exception.UserAlreadyExistsException;
import health.tracking.backend.model.Role;
import health.tracking.backend.model.entity.PatientRelative;
import health.tracking.backend.model.entity.User;
import health.tracking.backend.model.request.CreatePatientRelativeRequest;
import health.tracking.backend.model.request.UpdatePatientRelativeRequest;
import health.tracking.backend.model.response.GetPatientRelativeResponse;
import health.tracking.backend.repository.PatientRelativeRepository;
import health.tracking.backend.repository.UserRepository;
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
public class PatientRelativeServiceImpl implements PatientRelativeService, UserDetailsService {
    private final PatientRelativeRepository patientRelativeRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final PatientService patientService;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.getByUsername(username);
    }
    public PatientRelative getByUsername(String username) {
        return patientRelativeRepository.findByUserUsername(username);
    }
    public String createPatientRelative(CreatePatientRelativeRequest request) {
        if(userRepository.findByUsername(request.getUsername()) != null) {
            throw new UserAlreadyExistsException();
        }
        User user = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .address(request.getAddress())
                .emailAddress(request.getEmailAddress())
                .phoneNumber(request.getPhoneNumber())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .authorities(Collections.singleton(Role.PATIENT_RELATIVE))
                .registrationDate(new Date())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();

        PatientRelative newPatientRelative = PatientRelative.builder()
                .user(user)
                .patient(patientService.getByPatientById(request.getPatientId()))
                .relationship(request.getRelationship())
                .build();

        patientRelativeRepository.save(newPatientRelative);
        return "Patient Relative created successfully";
    }

    @Override
    public GetPatientRelativeResponse getPatientRelative(Long id) {
        PatientRelative patientRelative = patientRelativeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return GetPatientRelativeResponse.builder()
                .name(patientRelative.getUser().getName())
                .surname(patientRelative.getUser().getSurname())
                .username(patientRelative.getUser().getUsername())
                .phoneNumber(patientRelative.getUser().getPhoneNumber())
                .emailAddress(patientRelative.getUser().getEmailAddress())
                .address(patientRelative.getUser().getAddress())
                .relationship(patientRelative.getRelationship())
                .build();
    }

    @Override
    public String updatePatientRelative(UpdatePatientRelativeRequest request) {
        // Implement update logic
        // Update entity and convert to response
        return "PatientRelative updated successfully";
    }

    @Override
    public String deletePatientRelative(Long id) {
        // Implement delete logic
        patientRelativeRepository.deleteById(id);
        return "PatientRelative deleted successfully";
    }
}
