package health.tracking.backend.model.request;

import health.tracking.backend.model.Role;
import lombok.Builder;

import java.util.Date;
import java.util.Set;

@Builder
public record CreatePatientRequest(
        String name,
        String surname,
        String username,
        String password,
        Date birthDate,
        String gender,
        int height,
        int weight,
        String bloodType,
        String rfidTag,
        String phoneNumber,
        String emailAddress,
        String address) {
}