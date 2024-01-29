package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.HealthDataService;
import health.tracking.backend.model.request.CreateHealthDataRequest;
import health.tracking.backend.model.request.UpdateHealthDataRequest;
import health.tracking.backend.model.response.GetHealthDataResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health-data/v1")
@AllArgsConstructor
public class HealthDataController {
    private final HealthDataService healthdataService;

    @PostMapping
    public ResponseEntity<String> createHealthData(@RequestBody CreateHealthDataRequest request) {
        return ResponseEntity.ok(healthdataService.createHealthData(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetHealthDataResponse> getHealthData(@PathVariable Long id) {
        return ResponseEntity.ok(healthdataService.getHealthData(id));
    }

    @PutMapping
    ResponseEntity<String> updateHealthData(@RequestBody UpdateHealthDataRequest request) {
        return ResponseEntity.ok(healthdataService.updateHealthData(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHealthData(@PathVariable Long id) {
        return ResponseEntity.ok(healthdataService.deleteHealthData(id));
    }
}
