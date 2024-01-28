package health.tracking.backend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
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
    private String frequency;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
}
