package health.tracking.backend.repository;

import health.tracking.backend.model.entity.PatientRelative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRelativeRepository extends JpaRepository<PatientRelative,Long> {
    PatientRelative findByUserUsername(String userName);
}
