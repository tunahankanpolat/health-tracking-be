package health.tracking.backend.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    DOCTOR,
    ADMIN,
    PATIENT,
    PATIENT_RELATIVE;

    @Override
    public String getAuthority() {
        return name();
    }
}