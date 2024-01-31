package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.DoctorService;
import health.tracking.backend.model.request.CreateDoctorRequest;
import health.tracking.backend.model.request.UpdateDoctorRequest;
import health.tracking.backend.model.response.GetDoctorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor/v1")
@AllArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<String> createDoctor(@Valid @RequestBody CreateDoctorRequest request) {
        return ResponseEntity.ok(doctorService.createDoctor(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetDoctorResponse> getDoctor(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctor(id));
    }

    @PutMapping
    public ResponseEntity<String> updateDoctor(@Valid @RequestBody UpdateDoctorRequest request) {
        return ResponseEntity.ok(doctorService.updateDoctor(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.deleteDoctor(id));
    }
}
