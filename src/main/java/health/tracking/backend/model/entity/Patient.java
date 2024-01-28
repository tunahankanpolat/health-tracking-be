package health.tracking.backend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends User {
    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "birth_date")
    private Date birthDate;

    private int age;
    private String gender;
    private int height;
    private int weight;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "rfid_tag")
    private String rfidTag;

    @OneToMany(mappedBy = "patient")
    private List<HealthData> healthData;

    @OneToMany(mappedBy = "patient")
    private List<PatientRelative> patientRelatives;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "patient")
    private List<Prescription> prescriptions;

    @OneToOne(mappedBy = "patient")
    private DrugBox drugBox;
}
