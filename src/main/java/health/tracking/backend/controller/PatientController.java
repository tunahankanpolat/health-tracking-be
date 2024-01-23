package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient/v1/")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;
}
