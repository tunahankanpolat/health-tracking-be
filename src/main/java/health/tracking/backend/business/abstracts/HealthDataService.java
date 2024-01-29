package health.tracking.backend.business.abstracts;

import health.tracking.backend.model.request.CreateHealthDataRequest;
import health.tracking.backend.model.request.UpdateHealthDataRequest;
import health.tracking.backend.model.response.GetHealthDataResponse;

public interface HealthDataService {
    String createHealthData(CreateHealthDataRequest request);
    GetHealthDataResponse getHealthData(Long id);
    String updateHealthData(UpdateHealthDataRequest request);
    String deleteHealthData(Long id);
}
