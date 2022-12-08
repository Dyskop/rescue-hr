package by.skopinau.rescue.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
public class Position extends BaseEntity {
    @Column(name = "position_title", nullable = false, unique = true)
    private String positionTitle;

    public Position() {
    }

    public Position(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        if (!super.equals(o)) return false;

        Position position = (Position) o;

        return positionTitle.equals(position.positionTitle);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + positionTitle.hashCode();
        return result;
    }
}