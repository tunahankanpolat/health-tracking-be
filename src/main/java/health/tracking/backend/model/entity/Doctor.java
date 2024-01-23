package health.tracking.backend.model.entity;

import health.tracking.backend.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Doctor extends User {
    private String specialization;
}
