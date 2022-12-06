package by.skopinau.rescue.hr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "positions_log")
public class PositionsLog extends BaseEntity {
    @Column(name = "position_getting_date", nullable = false)
    private LocalDate positionGettingDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subdivision_id", nullable = false)
    private Subdivision subdivision;

    @Column(name = "order_publisher", nullable = false)
    private String orderPublisher;

    @Column(name = "order_number", nullable = false)
    private int orderNumber;

    public PositionsLog() {
    }

    public LocalDate getPositionGettingDate() {
        return positionGettingDate;
    }

    public void setPositionGettingDate(LocalDate positionGettingDate) {
        this.positionGettingDate = positionGettingDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Subdivision getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    public String getOrderPublisher() {
        return orderPublisher;
    }

    public void setOrderPublisher(String orderPublisher) {
        this.orderPublisher = orderPublisher;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionsLog)) return false;
        if (!super.equals(o)) return false;

        PositionsLog that = (PositionsLog) o;

        if (orderNumber != that.orderNumber) return false;
        if (!positionGettingDate.equals(that.positionGettingDate)) return false;
        return employee.equals(that.employee);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + positionGettingDate.hashCode();
        result = 31 * result + employee.hashCode();
        result = 31 * result + orderNumber;
        return result;
    }
}