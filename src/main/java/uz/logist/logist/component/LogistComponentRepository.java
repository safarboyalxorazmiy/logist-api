package uz.logist.logist.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogistComponentRepository extends JpaRepository<LogistComponentEntity, Long> {
    Optional<LogistComponentEntity> findByComponentIdAndLogistId(Long componentId, Long logistId);
}