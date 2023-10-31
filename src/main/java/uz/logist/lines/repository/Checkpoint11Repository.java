package uz.logist.lines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.logist.lines.entity.Checkpoint11Entity;

@Repository
public interface Checkpoint11Repository extends JpaRepository<Checkpoint11Entity, Long> {
}