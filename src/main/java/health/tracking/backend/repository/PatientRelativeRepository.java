package health.tracking.backend.repository;

import health.tracking.backend.model.entity.PatientRelative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRelativeRepository extends JpaRepository<PatientRelative,Long> {
    PatientRelative findByUsername(String userName);
}
