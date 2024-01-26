package health.tracking.backend.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends User {
    private Date birthDate;
    private int age;
    private String gender;
    private int height;
    private int weight;
    private String bloodType;
    private String rfidTag;
}
