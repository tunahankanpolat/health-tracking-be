package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.DoctorService;
import health.tracking.backend.model.Role;
import health.tracking.backend.model.entity.Doctor;
import health.tracking.backend.model.entity.User;
import health.tracking.backend.model.request.CreateDoctorRequest;
import health.tracking.backend.model.request.UpdateDoctorRequest;
import health.tracking.backend.model.response.GetDoctorResponse;
import health.tracking.backend.repository.DoctorRepository;
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
public class DoctorServiceImpl implements DoctorService, UserDetailsService {
    private final DoctorRepository doctorRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.getByUsername(username);
    }
    public Doctor getByUsername(String username) {
        return doctorRepository.findByUserUsername(username);
    }

    @Override
    public Doctor getByDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public String createDoctor(CreateDoctorRequest request) {
        User user = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .address(request.getAddress())
                .emailAddress(request.getEmailAddress())
                .phoneNumber(request.getPhoneNumber())
                .username(request.getUsername())
                .registrationDate(new Date())
                .authorities(Collections.singleton(Role.DOCTOR))
                .password(passwordEncoder.encode(request.getPassword()))
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();
        Doctor newDoctor = Doctor.builder()
                .user(user)
                .specialization(request.getSpecialization())
                .build();

        doctorRepository.save(newDoctor);
        return "Doctor created successfully";
    }

    @Override
    public GetDoctorResponse getDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return GetDoctorResponse.builder()
                .name(doctor.getUser().getName())
                .surname(doctor.getUser().getSurname())
                .username(doctor.getUser().getUsername())
                .phoneNumber(doctor.getUser().getPhoneNumber())
                .emailAddress(doctor.getUser().getEmailAddress())
                .address(doctor.getUser().getAddress())
                .specialization(doctor.getSpecialization())
                .build();
    }

    @Override
    public String updateDoctor(UpdateDoctorRequest request) {
        // Implement update logic
        // Update entity and convert to response
        return "Doctor updated successfully";
    }

    @Override
    public String deleteDoctor(Long id) {
        // Implement delete logic
        doctorRepository.deleteById(id);
        return "Doctor deleted successfully";
    }
}
