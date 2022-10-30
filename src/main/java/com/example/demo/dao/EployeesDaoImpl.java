package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.event.ListDataEvent;
import java.util.List;

@Repository
public class EployeesDaoImpl implements EmployeeDao {
    EntityManager entityManager;

    @Autowired
    public EployeesDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getEmplyees() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Employee",Employee.class);
        List<Employee>  employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class,id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(id);
    }
}
