package health.tracking.backend.business.concretes;

import health.tracking.backend.business.abstracts.DrugService;
import health.tracking.backend.model.entity.Drug;
import health.tracking.backend.model.request.CreateDrugRequest;
import health.tracking.backend.model.request.UpdateDrugRequest;
import health.tracking.backend.model.response.GetDrugResponse;
import health.tracking.backend.repository.DrugRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DrugServiceImpl implements DrugService {
    private final DrugRepository drugRepository;

    @Override
    public String createDrug(CreateDrugRequest request) {
        Drug drug = Drug.builder()
                .name(request.getName())
                .instructions(request.getInstructions())
                .description(request.getDescription())
                .build();
        drugRepository.save(drug);
        return "Drug created successfully";  // Return response
    }

    @Override
    public GetDrugResponse getDrug(Long id) {
        Drug drug = drugRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return GetDrugResponse.builder()
                .name(drug.getName())
                .instructions(drug.getInstructions())
                .description(drug.getDescription())
                .build();
    }

    @Override
    public String updateDrug(UpdateDrugRequest request) {
        Drug drug = drugRepository.findById(request.getId()).orElseThrow(EntityNotFoundException::new);
        //TODO: Implement update logic
        drugRepository.save(drug);
        return "Drug updated successfully";
    }

    @Override
    public String deleteDrug(Long id) {
        drugRepository.deleteById(id);
        return "Drug deleted successfully";
    }

    @Override
    public Drug getByDrugById(Long id) {
        return drugRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
