package health.tracking.backend.repository;

import health.tracking.backend.model.entity.DrugBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugBoxRepository extends JpaRepository<DrugBox, Long> {
}
