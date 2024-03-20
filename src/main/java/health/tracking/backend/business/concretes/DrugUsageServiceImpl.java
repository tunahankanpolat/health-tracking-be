package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.DrugService;
import health.tracking.backend.business.abstracts.DrugUsageService;
import health.tracking.backend.model.entity.Drug;
import health.tracking.backend.model.entity.DrugUsage;
import jakarta.persistence.EntityNotFoundException;
import health.tracking.backend.model.request.CreateDrugUsageRequest;
import health.tracking.backend.model.request.UpdateDrugUsageRequest;
import health.tracking.backend.model.response.GetDrugUsageResponse;
import health.tracking.backend.repository.DrugUsageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DrugUsageServiceImpl implements DrugUsageService {
    private final DrugUsageRepository drugusageRepository;
    private final DrugService drugService;

    public DrugUsage getDrugUsageById(Long id) {
        return drugusageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("DrugUsage with id " + id + " does not exist"));
    }

    @Override
    public String createDrugUsage(CreateDrugUsageRequest request) {
        Drug drug = drugService.getDrugById(request.getDrugId());
        DrugUsage drugusage = DrugUsage.builder()
                .drug(drug)
                .dosage(request.getDosage())
                .frequency(request.getFrequency())
                .build();
        drugusageRepository.save(drugusage);  // Save entity
        return "DrugUsage created successfully";  // Return response
    }

    @Override
    public GetDrugUsageResponse getDrugUsage(Long id) {
        DrugUsage drugusage = this.getDrugUsageById(id);
        return GetDrugUsageResponse.builder()
                .drug(drugService.getDrug(drugusage.getDrug().getId()))
                .dosage(drugusage.getDosage())
                .frequency(drugusage.getFrequency())
                .build();
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

    @Override
    public String createDrugUsages(List<DrugUsage> drugUsages) {
        drugusageRepository.saveAll(drugUsages);
        return "DrugUsages created successfully";
    }
}
