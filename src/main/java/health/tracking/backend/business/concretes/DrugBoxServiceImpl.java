package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.DrugBoxService;
import health.tracking.backend.model.request.CreateDrugBoxRequest;
import health.tracking.backend.model.request.UpdateDrugBoxRequest;
import health.tracking.backend.model.response.GetDrugBoxResponse;
import health.tracking.backend.repository.DrugBoxRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DrugBoxServiceImpl implements DrugBoxService {
    private final DrugBoxRepository drugboxRepository;

    @Override
    public String createDrugBox(CreateDrugBoxRequest request) {
        // Implement creation logic
        // Convert request to entity and save
        return "DrugBox created successfully";  // Return response
    }

    @Override
    public GetDrugBoxResponse getDrugBox(Long id) {
        // Implement read logic
        // Find entity and convert to response
        return new GetDrugBoxResponse();
    }

    @Override
    public String updateDrugBox(UpdateDrugBoxRequest request) {
        // Implement update logic
        // Update entity and convert to response
        return "DrugBox updated successfully";
    }

    @Override
    public String deleteDrugBox(Long id) {
        // Implement delete logic
        drugboxRepository.deleteById(id);
        return "DrugBox deleted successfully";
    }
}
