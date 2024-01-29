package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.DrugUsageService;
import health.tracking.backend.model.request.CreateDrugUsageRequest;
import health.tracking.backend.model.request.UpdateDrugUsageRequest;
import health.tracking.backend.model.response.GetDrugUsageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drug-usage/v1")
@AllArgsConstructor
public class DrugUsageController {
    private final DrugUsageService drugusageService;

    @PostMapping
    public ResponseEntity<String> createDrugUsage(@RequestBody CreateDrugUsageRequest request) {
        return ResponseEntity.ok(drugusageService.createDrugUsage(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetDrugUsageResponse> getDrugUsage(@PathVariable Long id) {
        return ResponseEntity.ok(drugusageService.getDrugUsage(id));
    }

    @PutMapping
    ResponseEntity<String> updateDrugUsage(@RequestBody UpdateDrugUsageRequest request) {
        return ResponseEntity.ok(drugusageService.updateDrugUsage(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrugUsage(@PathVariable Long id) {
        return ResponseEntity.ok(drugusageService.deleteDrugUsage(id));
    }
}
