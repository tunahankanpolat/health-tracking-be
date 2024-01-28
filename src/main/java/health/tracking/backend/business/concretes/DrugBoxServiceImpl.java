package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.DrugBoxService;
import health.tracking.backend.repository.DrugBoxRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DrugBoxServiceImpl implements DrugBoxService {
    private final DrugBoxRepository drugBoxRepository;
}
