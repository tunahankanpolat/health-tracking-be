package health.tracking.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrugUsage {
    @Id
    @Column(name = "drug_usage_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;

    private double dosage;
    private int frequency;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
}
