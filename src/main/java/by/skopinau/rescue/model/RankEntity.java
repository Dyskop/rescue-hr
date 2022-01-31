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
@Table(name = "ranks")
public class RankEntity extends BaseEntity{
    @Id
    @Column(name = "rank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rank_title")
    private String rankTitle;

    @OneToMany(mappedBy = "rankEntity")
    private Set<EmployeeEntity> employees = new HashSet<>();
}
