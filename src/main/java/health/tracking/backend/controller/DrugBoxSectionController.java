package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.DrugBoxSectionService;
import health.tracking.backend.model.request.CreateDrugBoxSectionRequest;
import health.tracking.backend.model.request.UpdateDrugBoxSectionRequest;
import health.tracking.backend.model.response.GetDrugBoxSectionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drug-box-section/v1")
@AllArgsConstructor
public class DrugBoxSectionController {
    private final DrugBoxSectionService drugboxsectionService;

    @PostMapping
    public ResponseEntity<String> createDrugBoxSection(@Valid @RequestBody CreateDrugBoxSectionRequest request) {
        return ResponseEntity.ok(drugboxsectionService.createDrugBoxSection(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetDrugBoxSectionResponse> getDrugBoxSection(@PathVariable Long id) {
        return ResponseEntity.ok(drugboxsectionService.getDrugBoxSection(id));
    }

    @PutMapping
    public ResponseEntity<String> updateDrugBoxSection(@Valid @RequestBody UpdateDrugBoxSectionRequest request) {
        return ResponseEntity.ok(drugboxsectionService.updateDrugBoxSection(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrugBoxSection(@PathVariable Long id) {
        return ResponseEntity.ok(drugboxsectionService.deleteDrugBoxSection(id));
    }
}
