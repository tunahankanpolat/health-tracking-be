package health.tracking.backend.model.entity;

import health.tracking.backend.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Set;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class User  implements UserDetails {
    private String name;
    private String surname;
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
    private Set<Role> authorities;
}
