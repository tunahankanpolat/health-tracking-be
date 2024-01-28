package health.tracking.backend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends User {
    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specialization;

    @ManyToMany
    @JoinTable(
        name = "doctor_patient",
        joinColumns = @JoinColumn(name = "doctor_id"),
        inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patients;

    @OneToMany(mappedBy = "doctor")
    private List<Prescription> prescriptions;
}
