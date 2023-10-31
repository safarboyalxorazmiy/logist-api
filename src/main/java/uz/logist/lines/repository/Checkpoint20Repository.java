package uz.logist.lines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.logist.lines.entity.Checkpoint1Entity;
import uz.logist.lines.entity.Checkpoint20Entity;

@Repository
public interface Checkpoint20Repository extends JpaRepository<Checkpoint20Entity, Long> {
}