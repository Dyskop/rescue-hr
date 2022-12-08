package by.skopinau.rescue.hr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ranks_log")
public class RanksLog extends BaseLogEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rank_id", nullable = false)
    private Rank rank;

    public RanksLog() {
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}