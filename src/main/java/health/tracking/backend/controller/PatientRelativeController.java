package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.PatientRelativeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-relative/v1/")
@AllArgsConstructor
public class PatientRelativeController {
    private final PatientRelativeService patientRelativeService;
}
