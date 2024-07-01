package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.DoctorService;
import health.tracking.backend.business.abstracts.PatientService;
import health.tracking.backend.exception.UserAlreadyExistsException;
import health.tracking.backend.model.Role;
import health.tracking.backend.model.entity.Doctor;
import health.tracking.backend.model.entity.Patient;
import health.tracking.backend.model.entity.User;
import health.tracking.backend.model.request.CreatePatientRequest;
import health.tracking.backend.model.request.UpdatePatientRequest;
import health.tracking.backend.model.response.GetDrugUsageResponse;
import health.tracking.backend.model.response.GetPatientResponse;
import health.tracking.backend.model.response.GetPrescriptionResponse;
import health.tracking.backend.repository.PatientRepository;
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
import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService, UserDetailsService {
    private final PatientRepository patientRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final DoctorService doctorService;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.getByUsername(username);
    }
    public Patient getByUsername(String username) {
        return patientRepository.findByUserUsername(username);
    }

    @Override
    public Patient getByPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient with id " + id + " does not exist"));
    }

    @Override
    public List<GetPatientResponse> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(patient -> GetPatientResponse.builder()
                .id(patient.getId())
                .name(patient.getUser().getName())
                .surname(patient.getUser().getSurname())
                .username(patient.getUser().getUsername())
                .phoneNumber(patient.getUser().getPhoneNumber())
                .emailAddress(patient.getUser().getEmailAddress())
                .address(patient.getUser().getAddress())
                .birthDate(patient.getBirthDate())
                .gender(patient.getGender())
                .height(patient.getHeight())
                .weight(patient.getWeight())
                .bloodType(patient.getBloodType())
                .rfidTag(patient.getRfidTag())
                .build()).toList();
    }

    @Override
    public List<GetPrescriptionResponse> getPatientPrescriptions(Long id) {
        Patient patient = this.getByPatientById(id);
        return patient.getPrescriptions().stream().map(prescription -> GetPrescriptionResponse.builder()
                .prescriptionId(prescription.getId())
                .prescriptionDate(prescription.getPrescriptionDate())
                .expiryDate(prescription.getExpiryDate())
                .instructions(prescription.getInstructions())
                .drugUsages(prescription.getDrugUsages().stream()
                        .map(drugUsage -> GetDrugUsageResponse.builder()
                                .drugUsageId(drugUsage.getId())
                                .drugName(drugUsage.getDrug().getName())
                                .dosage(drugUsage.getDosage())
                                .frequency(drugUsage.getFrequency())
                        .build()).toList())
                .build()).toList();
    }

    @Override
    public List<GetDrugUsageResponse> getPatientDrugUsages(Long id) {
        Patient patient = this.getByPatientById(id);
        return patient.getPrescriptions().stream()
                .flatMap(prescription ->
                        prescription.getDrugUsages().stream()
                .map(drugUsage ->
                        GetDrugUsageResponse.builder()
                .drugUsageId(drugUsage.getId())
                .drugId(drugUsage.getDrug().getId())
                .drugName(drugUsage.getDrug().getName())
                .dosage(drugUsage.getDosage())
                .frequency(drugUsage.getFrequency())
                .build())).toList();
    }

    public String createPatient(CreatePatientRequest request, Long doctorId) {
        if(userRepository.findByUsername(request.getUsername()) != null) {
            throw new UserAlreadyExistsException();
        }
        Doctor doctor = doctorService.getByDoctorById(doctorId);
        User user = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .address(request.getAddress())
                .emailAddress(request.getEmailAddress())
                .phoneNumber(request.getPhoneNumber())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .authorities(Collections.singleton(Role.PATIENT))
                .registrationDate(new Date())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();
        Patient newPatient = Patient.builder()
                .user(user)
                .doctors(Collections.singletonList(doctorService.getByDoctorById(doctorId)))
                .bloodType(request.getBloodType())
                .rfidTag(request.getRfidTag())
                .height(request.getHeight())
                .weight(request.getWeight())
                .gender(request.getGender())
                .birthDate(request.getBirthDate())
                .gender(request.getGender())
                .build();

        patientRepository.save(newPatient);
        return "Patient created successfully";
    }

    @Override
    public GetPatientResponse getPatient(Long id) {
        Patient patient = this.getByPatientById(id);
        return GetPatientResponse.builder()
                .name(patient.getUser().getName())
                .surname(patient.getUser().getSurname())
                .username(patient.getUser().getUsername())
                .phoneNumber(patient.getUser().getPhoneNumber())
                .emailAddress(patient.getUser().getEmailAddress())
                .address(patient.getUser().getAddress())
                .bloodType(patient.getBloodType())
                .rfidTag(patient.getRfidTag())
                .height(patient.getHeight())
                .weight(patient.getWeight())
                .gender(patient.getGender())
                .birthDate(patient.getBirthDate())
                .gender(patient.getGender())
                .build();
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
