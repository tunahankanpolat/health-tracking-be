package health.tracking.backend.model.entity;

import org.springframework.security.core.userdetails.UserDetails;

public interface ExtendedUserDetails extends UserDetails {
    Long getId();
}
