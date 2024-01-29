package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.request.CreateDrugBoxRequest;
import health.tracking.backend.model.request.UpdateDrugBoxRequest;
import health.tracking.backend.model.response.GetDrugBoxResponse;

public interface DrugBoxService {
    String createDrugBox(CreateDrugBoxRequest request);
    GetDrugBoxResponse getDrugBox(Long id);
    String updateDrugBox(UpdateDrugBoxRequest request);
    String deleteDrugBox(Long id);
}
