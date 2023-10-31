package uz.logist.lines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.logist.lines.entity.Checkpoint12Entity;
import uz.logist.lines.entity.Checkpoint1Entity;

@Repository
public interface Checkpoint12Repository extends JpaRepository<Checkpoint12Entity, Long> {
}