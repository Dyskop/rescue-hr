package by.skopinau.rescue.hr.entity;

import by.skopinau.rescue.hr.model.enums.Rank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "ranks_log")
public class RanksLog extends BaseLogEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
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