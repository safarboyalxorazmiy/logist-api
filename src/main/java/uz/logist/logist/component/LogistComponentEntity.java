package uz.logist.logist.component;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.logist.user.User;

@Getter
@Setter
@Entity
@Table(name = "logist_component")
public class LogistComponentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long componentId;

    @Column
    private Double quantity;

    @Column(name = "logist_id")
    private Long logistId;

    @ManyToOne
    @JoinColumn(name = "logist_id", insertable = false, updatable = false)
    private User logist;

    @Column
    private Boolean verified;
}