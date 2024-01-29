package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.HealthDataService;
import health.tracking.backend.model.request.CreateHealthDataRequest;
import health.tracking.backend.model.request.UpdateHealthDataRequest;
import health.tracking.backend.model.response.GetHealthDataResponse;
import health.tracking.backend.repository.HealthDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HealthDataServiceImpl implements HealthDataService {
    private final HealthDataRepository healthdataRepository;

    @Override
    public String createHealthData(CreateHealthDataRequest request) {
        // Implement creation logic
        // Convert request to entity and save
        return "HealthData created successfully";  // Return response
    }

    @Override
    public GetHealthDataResponse getHealthData(Long id) {
        // Implement read logic
        // Find entity and convert to response
        return new GetHealthDataResponse();
    }

    @Override
    public String updateHealthData(UpdateHealthDataRequest request) {
        // Implement update logic
        // Update entity and convert to response
        return "HealthData updated successfully";
    }

    @Override
    public String deleteHealthData(Long id) {
        // Implement delete logic
        healthdataRepository.deleteById(id);
        return "HealthData deleted successfully";
    }
}
