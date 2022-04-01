package by.skopinau.rescue.hr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ranks")
public class Rank extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rank_id")
    private int id;

    @Column(name = "rank_title")
    private String rankTitle;

    public Rank(String rankTitle) {
        this.rankTitle = rankTitle;
    }

    public Rank(int id) {
        this.id = id;
    }
}
