package by.skopinau.rescue.hr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "positions")
public class Position extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private int id;

    @Column(name = "position_title")
    private String positionTitle;

    public Position(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public Position(int id) {
        this.id = id;
    }
    /*

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees = new HashSet<>();

     */
}
