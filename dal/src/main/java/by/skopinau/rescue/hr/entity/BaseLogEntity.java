package by.skopinau.rescue.hr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class BaseLogEntity extends BaseEntity {
    @Column(name = "getting_date", nullable = false)
    private LocalDate gettingDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "order_publisher", nullable = false)
    private String orderPublisher;

    @Column(name = "order_number", nullable = false)
    private int orderNumber;

    public LocalDate getGettingDate() {
        return gettingDate;
    }

    public void setGettingDate(LocalDate gettingDate) {
        this.gettingDate = gettingDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getOrderPublisher() {
        return orderPublisher;
    }

    public void setOrderPublisher(String orderPublisher) {
        this.orderPublisher = orderPublisher;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseLogEntity)) return false;
        if (!super.equals(o)) return false;

        BaseLogEntity that = (BaseLogEntity) o;

        if (orderNumber != that.orderNumber) return false;
        if (!gettingDate.equals(that.gettingDate)) return false;
        if (!employee.equals(that.employee)) return false;
        return orderPublisher.equals(that.orderPublisher);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + gettingDate.hashCode();
        result = 31 * result + employee.hashCode();
        result = 31 * result + orderPublisher.hashCode();
        result = 31 * result + orderNumber;
        return result;
    }
}
