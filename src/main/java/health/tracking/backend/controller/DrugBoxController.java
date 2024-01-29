package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.DrugBoxService;
import health.tracking.backend.model.request.CreateDrugBoxRequest;
import health.tracking.backend.model.request.UpdateDrugBoxRequest;
import health.tracking.backend.model.response.GetDrugBoxResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drug-box/v1")
@AllArgsConstructor
public class DrugBoxController {
    private final DrugBoxService drugboxService;

    @PostMapping
    public ResponseEntity<String> createDrugBox(@RequestBody CreateDrugBoxRequest request) {
        return ResponseEntity.ok(drugboxService.createDrugBox(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetDrugBoxResponse> getDrugBox(@PathVariable Long id) {
        return ResponseEntity.ok(drugboxService.getDrugBox(id));
    }

    @PutMapping
    ResponseEntity<String> updateDrugBox(@RequestBody UpdateDrugBoxRequest request) {
        return ResponseEntity.ok(drugboxService.updateDrugBox(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrugBox(@PathVariable Long id) {
        return ResponseEntity.ok(drugboxService.deleteDrugBox(id));
    }
}
