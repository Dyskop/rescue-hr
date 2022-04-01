package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.dao.EmployeeDaoHibernateImpl;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Position;
import by.skopinau.rescue.hr.model.Rank;
import by.skopinau.rescue.hr.model.Subdivision;

import java.time.LocalDate;

public class HibernateApp {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1993, 3, 17);
        Rank rank = new Rank("капитан");
        Position position = new Position("инспектор");
        Subdivision subdivision = new Subdivision("ИНиП");

        Employee employee = new Employee("Скопинов", "Дмитрий", "Николаевич",
                date, rank, position,subdivision);

        EmployeeDaoHibernateImpl employeeDaoHibernate = new EmployeeDaoHibernateImpl();
        employeeDaoHibernate.save(employee);



    }
}