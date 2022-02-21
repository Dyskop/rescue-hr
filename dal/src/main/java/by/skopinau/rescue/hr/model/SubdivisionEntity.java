package by.skopinau.rescue.hr.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subdivisions")
public class SubdivisionEntity extends BaseEntity {
    @Id
    @Column(name = "subdivision_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subdivision_title")
    private String subdivisionTitle;
/*
    @OneToMany(mappedBy = "rankEntity")
    private Set<EmployeeEntity> employees = new HashSet<>();

 */
}
