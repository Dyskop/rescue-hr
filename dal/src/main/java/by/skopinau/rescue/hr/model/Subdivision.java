package by.skopinau.rescue.hr.model;

import lombok.*;

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