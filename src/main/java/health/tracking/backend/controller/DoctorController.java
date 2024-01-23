package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctor/v1/")
@AllArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
}
