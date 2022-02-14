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
@AttributeOverride(name = "id", column = @Column(name = "image_id"))
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

    @Column(name = "rank")
    @Enumerated(EnumType.STRING)
    private Rank rank;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subdivision_id", nullable = false)
    private SubdivisionEntity subdivisionEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", nullable = false)
    private PositionEntity positionEntity;
}
