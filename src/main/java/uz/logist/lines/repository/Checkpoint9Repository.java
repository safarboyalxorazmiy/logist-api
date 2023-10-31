package uz.logist.lines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.logist.lines.entity.Checkpoint1Entity;
import uz.logist.lines.entity.Checkpoint9Entity;

@Repository
public interface Checkpoint9Repository extends JpaRepository<Checkpoint9Entity, Long> {
}