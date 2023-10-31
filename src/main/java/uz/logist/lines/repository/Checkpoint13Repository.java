package uz.logist.lines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.logist.lines.entity.Checkpoint13Entity;
import uz.logist.lines.entity.Checkpoint1Entity;

@Repository
public interface Checkpoint13Repository extends JpaRepository<Checkpoint13Entity, Long> {
}