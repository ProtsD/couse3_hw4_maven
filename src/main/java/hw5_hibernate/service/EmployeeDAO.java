package hw5_hibernate.service;

import hw5_hibernate.model.Employee;
import javax.persistence.EntityManager;
import java.util.List;
public interface EmployeeDAO {

    void add(Employee employee, EntityManager entityManager);

    Employee getById(int id, EntityManager entityManager);

    void updateEmployee(int id, Employee employee, EntityManager entityManager);

    void deleteById(int id, EntityManager entityManager);

    List<Employee> getAllEmployee(EntityManager entityManager);

}
