package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.DrugBoxService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/drug-box/v1/")
@AllArgsConstructor
public class DrugBoxController {
    private final DrugBoxService drugBoxService;
}
