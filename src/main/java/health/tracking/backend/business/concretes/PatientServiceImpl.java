package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.PatientService;
import health.tracking.backend.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
}
