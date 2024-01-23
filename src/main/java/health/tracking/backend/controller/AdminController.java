package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/v1/")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
}
