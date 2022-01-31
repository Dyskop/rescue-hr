package by.skopinau.rescue.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeEntity extends BaseEntity {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private LocalDate birthday;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rank_id", nullable = false)
    private RankEntity rankEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subdivision_id", nullable = false)
    private SubdivisionEntity subdivisionEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", nullable = false)
    private PositionEntity positionEntity;
}
