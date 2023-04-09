package hw6_hibernate_several_tables.service;

import hw6_hibernate_several_tables.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void add(Employee employee, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    @Override
    public Employee getById(int id, EntityManager entityManager) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void updateEmployee(Employee employee, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteById(int id, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(getById(id, entityManager));
        } catch (IllegalArgumentException e) {
            System.out.println("The employee with id = " + id + " doesn't exist");
            e.printStackTrace();
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Employee> getAllEmployee(EntityManager entityManager) {
        String jpqlQuery = "SELECT s FROM Employee s";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }
}
