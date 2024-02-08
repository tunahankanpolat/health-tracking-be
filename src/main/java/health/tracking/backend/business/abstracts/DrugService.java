package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.entity.Drug;
import health.tracking.backend.model.request.CreateDrugRequest;
import health.tracking.backend.model.request.UpdateDrugRequest;
import health.tracking.backend.model.response.GetDrugResponse;

public interface DrugService {
    String createDrug(CreateDrugRequest request);
    GetDrugResponse getDrug(Long id);
    String updateDrug(UpdateDrugRequest request);
    String deleteDrug(Long id);
    Drug getByDrugById(Long id);
}
