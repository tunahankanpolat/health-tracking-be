package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.PatientService;
import health.tracking.backend.model.entity.Doctor;
import health.tracking.backend.model.request.CreatePatientRequest;
import health.tracking.backend.model.request.UpdatePatientRequest;
import health.tracking.backend.model.response.GetDrugUsageResponse;
import health.tracking.backend.model.response.GetPatientResponse;
import health.tracking.backend.model.response.GetPrescriptionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient/v1")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @PostMapping
    public ResponseEntity<String> createPatient(@Valid @RequestBody CreatePatientRequest request, @AuthenticationPrincipal Doctor principal) {
        return ResponseEntity.ok(patientService.createPatient(request, principal.getId()));
    }

    @GetMapping("/{id}/prescriptions")
    public ResponseEntity<List<GetPrescriptionResponse>> getPatientPrescriptions(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientPrescriptions(id));
    }

    @GetMapping("/{id}/drug-usages")
    public ResponseEntity<List<GetDrugUsageResponse>> getPatientDrugUsages(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientDrugUsages(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPatientResponse> getPatient(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatient(id));
    }

    @GetMapping()
    public ResponseEntity<List<GetPatientResponse>> getPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

    @PutMapping
    public ResponseEntity<String> updatePatient(@Valid @RequestBody UpdatePatientRequest request) {
        return ResponseEntity.ok(patientService.updatePatient(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.deletePatient(id));
    }
}
