package by.skopinau.rescue.hr.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "positions_subdivisions_link")
public class State extends BaseEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subdivision_id", nullable = false)
    private Subdivision subdivision;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @Column(name = "state_amount")
    private int StateAmount;
}