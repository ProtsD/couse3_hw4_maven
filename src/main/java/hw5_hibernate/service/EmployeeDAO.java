package hw5_hibernate.service;

import hw5_hibernate.model.Employee1;
import javax.persistence.EntityManager;
import java.util.List;
public interface EmployeeDAO {

    void add(Employee1 employee, EntityManager entityManager);

    Employee1 getById(int id, EntityManager entityManager);

    void updateEmployee(int id, Employee1 employee, EntityManager entityManager);

    void deleteById(int id, EntityManager entityManager);

    List<Employee1> getAllEmployee(EntityManager entityManager);

}
