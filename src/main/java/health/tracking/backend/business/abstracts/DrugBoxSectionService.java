package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.request.CreateDrugBoxSectionRequest;
import health.tracking.backend.model.request.UpdateDrugBoxSectionRequest;
import health.tracking.backend.model.response.GetDrugBoxSectionResponse;

public interface DrugBoxSectionService {
    String createDrugBoxSection(CreateDrugBoxSectionRequest request);
    GetDrugBoxSectionResponse getDrugBoxSection(Long id);
    String updateDrugBoxSection(UpdateDrugBoxSectionRequest request);
    String deleteDrugBoxSection(Long id);
}
