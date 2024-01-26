package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.PatientService;
import health.tracking.backend.model.request.CreatePatientRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient/v1")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @PostMapping
    public ResponseEntity<String> createPatient(@RequestBody CreatePatientRequest request) {
        return ResponseEntity.ok(patientService.createPatient(request));
    }
}
