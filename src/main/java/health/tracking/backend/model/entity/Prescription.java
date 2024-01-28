package health.tracking.backend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
    @Column(name = "prescription_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date prescriptionDate;
    private Date expiryDate;
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToMany(mappedBy = "prescription")
    private List<DrugUsage> drugUsages;
}
