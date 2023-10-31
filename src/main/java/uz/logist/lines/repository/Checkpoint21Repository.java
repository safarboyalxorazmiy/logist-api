package uz.logist.lines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.logist.lines.entity.Checkpoint1Entity;
import uz.logist.lines.entity.Checkpoint21Entity;

@Repository
public interface Checkpoint21Repository extends JpaRepository<Checkpoint21Entity, Long> {
}