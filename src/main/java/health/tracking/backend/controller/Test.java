package health.tracking.backend.controller;

import health.tracking.backend.business.concretes.AdminServiceImpl;
import health.tracking.backend.business.concretes.DoctorServiceImpl;
import health.tracking.backend.core.utils.jwt.JwtUtils;
import health.tracking.backend.model.Role;
import health.tracking.backend.model.request.CreateAdminRequest;
import health.tracking.backend.model.request.CreateDoctorRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
    public ResponseEntity<String> token(@RequestBody String token){
        CreateDoctorRequest request = CreateDoctorRequest.builder()
                .name("altay")
                .surname("tuna")
                .address("istanbul")
                .username("juarre")
                .phoneNumber("123456789")
                .specialization("TIP")
                .emailAddress("tuna@gmail.com")
                .password("123456")
                .build();
        log.error("request: {}", request);
        doctorService.createDoctor(request);
        return ResponseEntity.ok(jwtUtils.generateToken(request.getUsername()));
    }
}
