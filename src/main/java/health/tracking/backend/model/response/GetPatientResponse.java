package health.tracking.backend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPatientResponse {
    private String name;
    private String surname;
    private String username;
    private Date birthDate;
    private String gender;
    private int height;
    private int weight;
    private String bloodType;
    private String rfidTag;
    private String phoneNumber;
    private String emailAddress;
    private String address;
}
