package by.skopinau.rescue.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Subdivision extends BaseEntity {
    @Column(name = "subdivision_title", nullable = false, unique = true)
    private String subdivisionTitle;

    public Subdivision() {
    }

    public String getSubdivisionTitle() {
        return subdivisionTitle;
    }

    public void setSubdivisionTitle(String subdivisionTitle) {
        this.subdivisionTitle = subdivisionTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subdivision)) return false;
        if (!super.equals(o)) return false;

        Subdivision that = (Subdivision) o;

        return subdivisionTitle.equals(that.subdivisionTitle);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + subdivisionTitle.hashCode();
        return result;
    }
}