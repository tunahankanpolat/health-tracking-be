package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.PrescriptionService;
import health.tracking.backend.model.request.CreatePrescriptionRequest;
import health.tracking.backend.model.request.UpdatePrescriptionRequest;
import health.tracking.backend.model.response.GetPrescriptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescription/v1")
@AllArgsConstructor
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<String> createPrescription(@RequestBody CreatePrescriptionRequest request) {
        return ResponseEntity.ok(prescriptionService.createPrescription(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPrescriptionResponse> getPrescription(@PathVariable Long id) {
        return ResponseEntity.ok(prescriptionService.getPrescription(id));
    }

    @PutMapping
    ResponseEntity<String> updatePrescription(@RequestBody UpdatePrescriptionRequest request) {
        return ResponseEntity.ok(prescriptionService.updatePrescription(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrescription(@PathVariable Long id) {
        return ResponseEntity.ok(prescriptionService.deletePrescription(id));
    }
}
