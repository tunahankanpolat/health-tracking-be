package health.tracking.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthData {
    @Id
    @Column(name = "health_data_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date timestamp;
    private int heartRate;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
