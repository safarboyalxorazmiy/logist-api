package uz.logist.components;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "components")
public class ComponentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private Long checkpoint;

    @Column
    private String unit;

    @Column
    private String specs;

    @Column
    private Integer status;

    @Column
    private String photo;

    @Column
    private LocalDateTime time;

    @Column
    private Integer type;

    @Column
    private Double weight;

    @Column
    private Long available;

    @Column
    private String inner_code;

    @Column
    private Integer income;
}