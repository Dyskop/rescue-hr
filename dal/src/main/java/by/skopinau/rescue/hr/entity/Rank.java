package by.skopinau.rescue.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ranks")
public class Rank extends BaseEntity{
    @Column(name = "rank_title", nullable = false, unique = true)
    private String rankTitle;

    public Rank() {
    }

    public String getRankTitle() {
        return rankTitle;
    }

    public void setRankTitle(String rankTitle) {
        this.rankTitle = rankTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rank)) return false;
        if (!super.equals(o)) return false;

        Rank rank = (Rank) o;

        return rankTitle.equals(rank.rankTitle);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + rankTitle.hashCode();
        return result;
    }
}