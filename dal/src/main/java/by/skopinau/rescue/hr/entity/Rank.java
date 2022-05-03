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
@Table(name = "ranks")
public class Rank extends BaseEntity{
    @Column(name = "rank_title")
    private String rankTitle;
}