package uz.logist.lines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.logist.lines.entity.Checkpoint10Entity;

@Repository
public interface Checkpoint10Repository extends JpaRepository<Checkpoint10Entity, Long> {
}