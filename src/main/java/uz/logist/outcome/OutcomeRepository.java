package uz.logist.outcome;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutcomeRepository extends JpaRepository<OutcomeEntity, Long> {
  List<OutcomeEntity> findByCommentIsNull();
}