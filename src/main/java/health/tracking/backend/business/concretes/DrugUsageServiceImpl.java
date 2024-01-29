package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.DrugUsageService;
import health.tracking.backend.model.request.CreateDrugUsageRequest;
import health.tracking.backend.model.request.UpdateDrugUsageRequest;
import health.tracking.backend.model.response.GetDrugUsageResponse;
import health.tracking.backend.repository.DrugUsageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DrugUsageServiceImpl implements DrugUsageService {
    private final DrugUsageRepository drugusageRepository;

    @Override
    public String createDrugUsage(CreateDrugUsageRequest request) {
        // Implement creation logic
        // Convert request to entity and save
        return "DrugUsage created successfully";  // Return response
    }

    @Override
    public GetDrugUsageResponse getDrugUsage(Long id) {
        // Implement read logic
        // Find entity and convert to response
        return new GetDrugUsageResponse();
    }

    @Override
    public String updateDrugUsage(UpdateDrugUsageRequest request) {
        // Implement update logic
        // Update entity and convert to response
        return "DrugUsage updated successfully";
    }

    @Override
    public String deleteDrugUsage(Long id) {
        // Implement delete logic
        drugusageRepository.deleteById(id);
        return "DrugUsage deleted successfully";
    }
}
