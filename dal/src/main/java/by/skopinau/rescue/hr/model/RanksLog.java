package by.skopinau.rescue.hr.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ranks_log")
public class RanksLog extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ranks_log_id")
    private int id;

    @Column(name = "rank_getting_date")
    private LocalDate rankGettingDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rank_id", nullable = false)
    private Rank rank;

    @Column(name = "order_publisher")
    private String orderPublisher;

    @Column(name = "order_number")
    private int orderNumber;

    public RanksLog(LocalDate rankGettingDate, Employee employee, Rank rank, String orderPublisher, int orderNumber) {
        this.rankGettingDate = rankGettingDate;
        this.employee = employee;
        this.rank = rank;
        this.orderPublisher = orderPublisher;
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "RanksLog{" +
                "id=" + id +
                ", rankGettingDate=" + rankGettingDate +
                ", employee=" + employee +
                ", rank=" + rank +
                ", orderPublisher='" + orderPublisher + '\'' +
                ", orderNumber=" + orderNumber +
                '}';
    }
}