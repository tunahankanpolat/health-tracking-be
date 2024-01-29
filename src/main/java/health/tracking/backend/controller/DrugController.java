package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.DrugService;
import health.tracking.backend.model.request.CreateDrugRequest;
import health.tracking.backend.model.request.UpdateDrugRequest;
import health.tracking.backend.model.response.GetDrugResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drug/v1")
@AllArgsConstructor
public class DrugController {
    private final DrugService drugService;

    @PostMapping
    public ResponseEntity<String> createDrug(@RequestBody CreateDrugRequest request) {
        return ResponseEntity.ok(drugService.createDrug(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetDrugResponse> getDrug(@PathVariable Long id) {
        return ResponseEntity.ok(drugService.getDrug(id));
    }

    @PutMapping
    ResponseEntity<String> updateDrug(@RequestBody UpdateDrugRequest request) {
        return ResponseEntity.ok(drugService.updateDrug(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrug(@PathVariable Long id) {
        return ResponseEntity.ok(drugService.deleteDrug(id));
    }
}
