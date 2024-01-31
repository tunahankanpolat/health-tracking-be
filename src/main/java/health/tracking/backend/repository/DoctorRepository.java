package health.tracking.backend.repository;

import health.tracking.backend.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor findByUserUsername(String userName);
}
