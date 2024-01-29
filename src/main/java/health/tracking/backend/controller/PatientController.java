package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.PatientService;
import health.tracking.backend.model.request.CreatePatientRequest;
import health.tracking.backend.model.request.UpdatePatientRequest;
import health.tracking.backend.model.response.GetPatientResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient/v1")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @PostMapping
    public ResponseEntity<String> createPatient(@RequestBody CreatePatientRequest request) {
        return ResponseEntity.ok(patientService.createPatient(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPatientResponse> getPatient(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatient(id));
    }

    @PutMapping
    ResponseEntity<String> updatePatient(@RequestBody UpdatePatientRequest request) {
        return ResponseEntity.ok(patientService.updatePatient(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.deletePatient(id));
    }
}
