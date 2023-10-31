package uz.logist.lines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.logist.lines.entity.Checkpoint1Entity;
import uz.logist.lines.entity.Checkpoint2Entity;

@Repository
public interface Checkpoint2Repository extends JpaRepository<Checkpoint2Entity, Long> {
}