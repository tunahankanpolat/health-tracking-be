package health.tracking.backend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrugBox {
    @Id
    @Column(name = "drug_box_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private int columnCount;
    private int rowCount;

    @OneToMany(mappedBy = "drugBox")
    private List<DrugBoxSection> drugBoxSections;
}
