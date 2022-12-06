package by.skopinau.rescue.hr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ranks_log")
public class RanksLog extends BaseEntity {
    @Column(name = "rank_getting_date", nullable = false)
    private LocalDate rankGettingDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rank_id", nullable = false)
    private Rank rank;

    @Column(name = "order_publisher", nullable = false)
    private String orderPublisher;

    @Column(name = "order_number", nullable = false)
    private int orderNumber;

    public RanksLog() {
    }

    public LocalDate getRankGettingDate() {
        return rankGettingDate;
    }

    public void setRankGettingDate(LocalDate rankGettingDate) {
        this.rankGettingDate = rankGettingDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
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
        if (!(o instanceof RanksLog)) return false;
        if (!super.equals(o)) return false;

        RanksLog ranksLog = (RanksLog) o;

        if (orderNumber != ranksLog.orderNumber) return false;
        if (!rankGettingDate.equals(ranksLog.rankGettingDate)) return false;
        return employee.equals(ranksLog.employee);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + rankGettingDate.hashCode();
        result = 31 * result + employee.hashCode();
        result = 31 * result + orderNumber;
        return result;
    }
}