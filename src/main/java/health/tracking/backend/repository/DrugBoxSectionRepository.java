package health.tracking.backend.repository;

import health.tracking.backend.model.entity.DrugBoxSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugBoxSectionRepository extends JpaRepository<DrugBoxSection, Long> {
}
