package health.tracking.backend.repository;

import health.tracking.backend.model.entity.DrugUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugUsageRepository extends JpaRepository<DrugUsage, Long> {
}
