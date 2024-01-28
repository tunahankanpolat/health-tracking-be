package health.tracking.backend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrugBoxSection {
    @Id
    @Column(name = "drug_box_section_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int columnCoordinate;
    private int rowCoordinate;

    @ManyToOne
    @JoinColumn(name = "drug_box_id")
    private DrugBox drugBox;

    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;
}
