package by.skopinau.rescue.hr.entity;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "positions")
public class Position extends BaseEntity {
    @Column(name = "position_title")
    private String positionTitle;
}