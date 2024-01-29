package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.PatientRelativeService;
import health.tracking.backend.model.request.CreatePatientRelativeRequest;
import health.tracking.backend.model.request.UpdatePatientRelativeRequest;
import health.tracking.backend.model.response.GetPatientRelativeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient-relative/v1")
@AllArgsConstructor
public class PatientRelativeController {
    private final PatientRelativeService patientRelativeService;

    @PostMapping
    public ResponseEntity<String> createPatientRelative(@RequestBody CreatePatientRelativeRequest request) {
        return ResponseEntity.ok(patientRelativeService.createPatientRelative(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPatientRelativeResponse> getPatientRelative(@PathVariable Long id) {
        return ResponseEntity.ok(patientRelativeService.getPatientRelative(id));
    }

    @PutMapping
    ResponseEntity<String> updatePatientRelative(@RequestBody UpdatePatientRelativeRequest request) {
        return ResponseEntity.ok(patientRelativeService.updatePatientRelative(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientRelative(@PathVariable Long id) {
        return ResponseEntity.ok(patientRelativeService.deletePatientRelative(id));
    }
}
