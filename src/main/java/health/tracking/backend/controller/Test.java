package health.tracking.backend.controller;

import health.tracking.backend.business.concretes.AdminServiceImpl;
import health.tracking.backend.business.concretes.DoctorServiceImpl;
import health.tracking.backend.core.utils.jwt.JwtUtils;
import health.tracking.backend.model.request.CreateAdminRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/v1/")
@AllArgsConstructor
@Slf4j
public class Test {
    private JwtUtils jwtUtils;
    private final AdminServiceImpl adminService;
    private final DoctorServiceImpl doctorService;
    private final AuthenticationManager authenticationManager;
    @PostMapping("login")
    public ResponseEntity<Authentication> login(){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("juarre", "123456"));
        return ResponseEntity.ok(authentication);
    }

    @PostMapping("token")
    public ResponseEntity<String> token(){
        CreateAdminRequest request = CreateAdminRequest.builder()
                .name("altay")
                .surname("tuna")
                .address("istanbul")
                .username("juarre")
                .phoneNumber("123456789")
                .emailAddress("tuna@gmail.com")
                .password("123456")
                .build();
        log.error("request: {}", request);
        adminService.createAdmin(request);
        return ResponseEntity.ok(jwtUtils.generateToken(request.getUsername()));
    }
}
