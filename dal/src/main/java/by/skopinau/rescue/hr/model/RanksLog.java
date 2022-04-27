package by.skopinau.rescue.hr.model;

import javax.persistence.*;
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
}