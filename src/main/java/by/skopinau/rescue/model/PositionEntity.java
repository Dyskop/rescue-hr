package by.skopinau.rescue.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "positions")
public class PositionEntity extends BaseEntity{
    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position_title")
    private String positionTitle;

    @OneToMany(mappedBy = "positionEntity")
    private Set<EmployeeEntity> employees = new HashSet<>();
}
