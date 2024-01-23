package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.PatientRelativeService;
import health.tracking.backend.repository.PatientRelativeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientRelativeServiceImpl implements PatientRelativeService {
    private final PatientRelativeRepository patientRelativeRepository;
}
