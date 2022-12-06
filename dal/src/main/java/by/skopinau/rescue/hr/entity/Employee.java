package by.skopinau.rescue.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String patronymic;

    @Column(nullable = false)
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "rank_id", nullable = false)
    private Rank rank;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "subdivision_id", nullable = false)
    private Subdivision subdivision;

    public Employee() {
    }

    public Employee(String surname, String name, String patronymic, LocalDate birthday,
                    Rank rank, Position position, Subdivision subdivision) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.rank = rank;
        this.position = position;
        this.subdivision = subdivision;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Subdivision getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        if (!surname.equals(employee.surname)) return false;
        if (!name.equals(employee.name)) return false;
        if (!patronymic.equals(employee.patronymic)) return false;
        return birthday.equals(employee.birthday);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + patronymic.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", rank=" + rank +
                ", position=" + position +
                ", subdivision=" + subdivision +
                '}';
    }
}