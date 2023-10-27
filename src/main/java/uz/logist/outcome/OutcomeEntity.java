package uz.logist.outcome;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = "outcome")
public class OutcomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long component_id;

    @Column
    private Long checkpoint_id;

    @Column
    private LocalDateTime create;

    @Column
    private Double quantity;

    @Column
    private String comment;

    @Column
    private LocalDateTime update;

    @Override
    public String toString() {
        return "OutcomeEntity{" +
                "id=" + id +
                ", component_id=" + component_id +
                ", checkpoint_id=" + checkpoint_id +
                ", create=" + create +
                ", quantity=" + quantity +
                ", comment='" + comment + '\'' +
                ", update=" + update +
                '}';
    }
}