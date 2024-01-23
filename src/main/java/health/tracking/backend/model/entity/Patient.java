package health.tracking.backend.model.entity;

import health.tracking.backend.model.User;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Patient extends User {
    private Date birthDate;
    private int age;
    private String gender;
    private int height;
    private int weight;
    private String bloodType;
    private String rfidTag;
}
