package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.DrugBoxSectionService;
import health.tracking.backend.model.request.CreateDrugBoxSectionRequest;
import health.tracking.backend.model.request.UpdateDrugBoxSectionRequest;
import health.tracking.backend.model.response.GetDrugBoxSectionResponse;
import health.tracking.backend.repository.DrugBoxSectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DrugBoxSectionServiceImpl implements DrugBoxSectionService {
    private final DrugBoxSectionRepository drugboxsectionRepository;

    @Override
    public String createDrugBoxSection(CreateDrugBoxSectionRequest request) {
        // Implement creation logic
        // Convert request to entity and save
        return "DrugBoxSection created successfully";  // Return response
    }

    @Override
    public GetDrugBoxSectionResponse getDrugBoxSection(Long id) {
        // Implement read logic
        // Find entity and convert to response
        return new GetDrugBoxSectionResponse();
    }

    @Override
    public String updateDrugBoxSection(UpdateDrugBoxSectionRequest request) {
        // Implement update logic
        // Update entity and convert to response
        return "DrugBoxSection updated successfully";
    }

    @Override
    public String deleteDrugBoxSection(Long id) {
        // Implement delete logic
        drugboxsectionRepository.deleteById(id);
        return "DrugBoxSection deleted successfully";
    }
}
