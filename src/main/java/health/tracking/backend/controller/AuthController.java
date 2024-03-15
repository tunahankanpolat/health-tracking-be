package health.tracking.backend.controller;

import health.tracking.backend.core.utils.jwt.JwtUtils;
import health.tracking.backend.model.request.AuthRequest;
import health.tracking.backend.model.response.AuthResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/v1")
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken
                        (request.getUsername(), request.getPassword()));
        GrantedAuthority role = authentication.getAuthorities().stream().findFirst().get();
        if(authentication.isAuthenticated())
            return ResponseEntity.ok(AuthResponse.builder().
                    token(jwtUtils.generateToken(request.getUsername(), role))
                            .build());
        return ResponseEntity.badRequest().build();
    }
}
