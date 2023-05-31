package hw6_hibernate_several_tables.service;

import hw6_hibernate_several_tables.model.Employee;

import javax.persistence.EntityManager;
import java.util.List;
public interface EmployeeDAO {

    void add(Employee employee, EntityManager entityManager);

    Employee getById(int id, EntityManager entityManager);

    void updateEmployee(Employee employee, EntityManager entityManager);

    void deleteById(int id, EntityManager entityManager);

    List<Employee> getAllEmployee(EntityManager entityManager);

}
