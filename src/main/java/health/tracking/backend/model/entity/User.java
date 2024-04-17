package health.tracking.backend.model.entity;

import health.tracking.backend.model.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements ExtendedUserDetails {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(name = "registration_date")
    private Date registrationDate;
    @Column(name= "phone_number")
    private String phoneNumber;
    @Column(name = "email_address")
    private String emailAddress;
    private String address;
    @Column(name = "account_non_expired")
    private boolean accountNonExpired;
    @Column(name = "is_enabled")
    private boolean isEnabled;
    @Column(name = "account_non_locked")
    private boolean accountNonLocked;
    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> authorities;
}
