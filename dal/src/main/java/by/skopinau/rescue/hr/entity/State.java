package by.skopinau.rescue.hr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "positions_subdivisions_link")
public class State extends BaseEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subdivision_id", nullable = false)
    private Subdivision subdivision;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @Column(name = "state_amount", nullable = false)
    private int stateAmount;

    public State() {
    }

    public State(Subdivision subdivision, Position position, int stateAmount) {
        this.subdivision = subdivision;
        this.position = position;
        this.stateAmount = stateAmount;
    }

    public Subdivision getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getStateAmount() {
        return stateAmount;
    }

    public void setStateAmount(int stateAmount) {
        this.stateAmount = stateAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        if (!super.equals(o)) return false;

        State state = (State) o;

        if (stateAmount != state.stateAmount) return false;
        if (!subdivision.equals(state.subdivision)) return false;
        return position.equals(state.position);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + subdivision.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + stateAmount;
        return result;
    }
}