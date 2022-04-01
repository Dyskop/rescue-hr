package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.util.DynamicEntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmployeeDaoHibernateImpl extends BaseDaoHibernateImpl<Employee>{
    public EmployeeDaoHibernateImpl() {
        super(Employee.class);
    }
    // fix qlString
    /*
    public List<Employee> findBySurname(String surname) {
        EntityManager em = DynamicEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Employee> query = em.createQuery("select entity from Employee.class entity", Employee.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

     */
}
