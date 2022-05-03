package by.skopinau.rescue.hr.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ranks_log")
public class RanksLog extends BaseEntity {
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
}