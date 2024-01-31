package health.tracking.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
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
