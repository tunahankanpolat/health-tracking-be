package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.DrugService;
import health.tracking.backend.model.request.CreateDrugRequest;
import health.tracking.backend.model.request.UpdateDrugRequest;
import health.tracking.backend.model.response.GetDrugResponse;
import health.tracking.backend.repository.DrugRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DrugServiceImpl implements DrugService {
    private final DrugRepository drugRepository;

    @Override
    public String createDrug(CreateDrugRequest request) {
        // Implement creation logic
        // Convert request to entity and save
        return "Drug created successfully";  // Return response
    }

    @Override
    public GetDrugResponse getDrug(Long id) {
        // Implement read logic
        // Find entity and convert to response
        return new GetDrugResponse();
    }

    @Override
    public String updateDrug(UpdateDrugRequest request) {
        // Implement update logic
        // Update entity and convert to response
        return "Drug updated successfully";
    }

    @Override
    public String deleteDrug(Long id) {
        // Implement delete logic
        drugRepository.deleteById(id);
        return "Drug deleted successfully";
    }
}
