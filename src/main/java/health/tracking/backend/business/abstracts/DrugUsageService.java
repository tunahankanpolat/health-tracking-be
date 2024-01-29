package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.request.CreateDrugUsageRequest;
import health.tracking.backend.model.request.UpdateDrugUsageRequest;
import health.tracking.backend.model.response.GetDrugUsageResponse;

public interface DrugUsageService {
    String createDrugUsage(CreateDrugUsageRequest request);
    GetDrugUsageResponse getDrugUsage(Long id);
    String updateDrugUsage(UpdateDrugUsageRequest request);
    String deleteDrugUsage(Long id);
}
