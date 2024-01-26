package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.DoctorService;
import health.tracking.backend.model.request.CreateDoctorRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctor/v1")
@AllArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    @PostMapping
    public ResponseEntity<String> createDoctor(@RequestBody CreateDoctorRequest request) {
        return ResponseEntity.ok(doctorService.createDoctor(request));
    }
}
