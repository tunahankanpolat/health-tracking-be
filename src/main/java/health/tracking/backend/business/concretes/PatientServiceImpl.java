package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.PatientService;
import health.tracking.backend.model.Role;
import health.tracking.backend.model.entity.Patient;
import health.tracking.backend.model.request.CreatePatientRequest;
import health.tracking.backend.model.request.UpdatePatientRequest;
import health.tracking.backend.model.response.GetPatientResponse;
import health.tracking.backend.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

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
                .name(request.getName())
                .surname(request.getSurname())
                .address(request.getAddress())
                .emailAddress(request.getEmailAddress())
                .phoneNumber(request.getPhoneNumber())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .bloodType(request.getBloodType())
                .rfidTag(request.getRfidTag())
                .height(request.getHeight())
                .weight(request.getWeight())
                .gender(request.getGender())
                .birthDate(request.getBirthDate())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();

        patientRepository.save(newPatient);
        return "Patient Relative created successfully";
    }

    @Override
    public GetPatientResponse getPatient(Long id) {
        // Implement read logic
        // Find entity and convert to response
        return new GetPatientResponse();
    }

    @Override
    public String updatePatient(UpdatePatientRequest request) {
        // Implement update logic
        // Update entity and convert to response
        return "Patient updated successfully";
    }

    @Override
    public String deletePatient(Long id) {
        // Implement delete logic
        patientRepository.deleteById(id);
        return "Patient deleted successfully";
    }
}
