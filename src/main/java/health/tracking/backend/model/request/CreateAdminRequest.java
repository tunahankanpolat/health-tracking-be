package health.tracking.backend.model.request;

import health.tracking.backend.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateAdminRequest(
        String name,
        String surname,
        String username,
        String password,
        String phoneNumber,
        String emailAddress,
        String address) {
}