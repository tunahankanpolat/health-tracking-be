package health.tracking.backend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
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
