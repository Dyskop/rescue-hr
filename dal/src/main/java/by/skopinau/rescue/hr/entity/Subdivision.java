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
@Table(name = "subdivisions")
public class Subdivision extends BaseEntity {
    @Column(name = "subdivision_title")
    private String subdivisionTitle;
}