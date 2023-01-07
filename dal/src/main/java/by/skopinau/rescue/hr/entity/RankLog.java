package by.skopinau.rescue.hr.entity;

import by.skopinau.rescue.hr.model.enums.Rank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "rank_log")
public class RankLog extends BaseLogEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Rank rank;

    public RankLog() {
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}