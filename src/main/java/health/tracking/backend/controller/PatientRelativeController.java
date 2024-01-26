package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.PatientRelativeService;
import health.tracking.backend.model.request.CreatePatientRelativeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-relative/v1")
@AllArgsConstructor
public class PatientRelativeController {
    private final PatientRelativeService patientRelativeService;

    @PostMapping
    public ResponseEntity<String> createPatientRelative(@RequestBody CreatePatientRelativeRequest request) {
        return ResponseEntity.ok(patientRelativeService.createPatientRelative(request));
    }
}
