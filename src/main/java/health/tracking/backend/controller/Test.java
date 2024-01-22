package health.tracking.backend.controller;

import health.tracking.backend.core.utils.jwt.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test/v1/")
@AllArgsConstructor
public class Test {
    private JwtUtils jwtUtils;

    @PostMapping("login")
    public ResponseEntity<String> login(){
        Collection<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("HR_USER"));
        UserDetails user = new User("tuna", "kanpolat", authorities);
        Map<String, Object> claims = new HashMap<>();
        claims.put("altay", "tuna");
        claims.put("spor", "kanpolat");
        String token = jwtUtils.generateToken(user, claims);
        return ResponseEntity.ok(token);
    }

    @PostMapping("token")
    public ResponseEntity<String> token(@RequestBody String token){
        String username = jwtUtils.extractUsername(token);
        Object name = jwtUtils.extractClaim(token, claims -> claims.get("altay"));
        Object surn= jwtUtils.extractClaim(token, claims -> claims.get("spor"));
        return ResponseEntity.ok(username + " " + name + " " + surn);
    }
}
