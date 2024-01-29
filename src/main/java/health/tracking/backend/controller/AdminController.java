package health.tracking.backend.controller;

import health.tracking.backend.business.abstracts.AdminService;
import health.tracking.backend.model.request.CreateAdminRequest;
import health.tracking.backend.model.request.UpdateAdminRequest;
import health.tracking.backend.model.response.GetAdminResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/v1")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<String> createAdmin(@RequestBody CreateAdminRequest request) {
        return ResponseEntity.ok(adminService.createAdmin(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAdminResponse> getAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getAdmin(id));
    }

    @PutMapping
    ResponseEntity<String> updateAdmin(@RequestBody UpdateAdminRequest request) {
        return ResponseEntity.ok(adminService.updateAdmin(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteAdmin(id));
    }
}
