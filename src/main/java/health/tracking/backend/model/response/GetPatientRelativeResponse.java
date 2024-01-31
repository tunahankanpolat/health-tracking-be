package health.tracking.backend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPatientRelativeResponse {
    private String name;
    private String surname;
    private String username;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String relationship;
}
