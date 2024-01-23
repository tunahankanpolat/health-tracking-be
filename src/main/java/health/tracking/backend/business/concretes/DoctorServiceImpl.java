package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.DoctorService;
import health.tracking.backend.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
}
