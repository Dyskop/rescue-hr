package by.skopinau.rescue.hr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subdivisions")
public class Subdivision extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subdivision_id")
    private int id;

    @Column(name = "subdivision_title")
    private String subdivisionTitle;

    public Subdivision(String subdivisionTitle) {
        this.subdivisionTitle = subdivisionTitle;
    }

    public Subdivision(int id) {
        this.id = id;
    }
    /*
    @OneToMany(mappedBy = "rank")
    private Set<Employee> employees = new HashSet<>();

 */

}
