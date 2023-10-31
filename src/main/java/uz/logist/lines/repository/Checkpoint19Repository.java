package uz.logist.lines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.logist.lines.entity.Checkpoint19Entity;
import uz.logist.lines.entity.Checkpoint1Entity;

@Repository
public interface Checkpoint19Repository extends JpaRepository<Checkpoint19Entity, Long> {
}