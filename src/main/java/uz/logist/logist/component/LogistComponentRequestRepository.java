package uz.logist.logist.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogistComponentRequestRepository extends JpaRepository<LogistComponentRequestEntity, Long> {
  List<LogistComponentRequestEntity> findByVerifiedFalseAndLogistId(Long logistId);
}