package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.AdminService;
import health.tracking.backend.model.entity.Admin;
import health.tracking.backend.model.request.CreateAdminRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/v1")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @PostMapping
    public ResponseEntity<String> createAdmin(@RequestBody CreateAdminRequest request) {
        return ResponseEntity.ok(adminService.createAdmin(request));
    }
}
