package uz.logist.lines.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "19", schema = "checkpoints")
public class Checkpoint19Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "component_id")
    private Long componentId;

    @Column
    private Long quantity;
}