package hw5_hibernate.service;

import hw5_hibernate.model.Employee1;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void add(Employee1 employee, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    @Override
    public Employee1 getById(int id, EntityManager entityManager) {
        return entityManager.find(Employee1.class, id);
    }

    @Override
    public void updateEmployee(int id, Employee1 employee, EntityManager entityManager) {
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
    public List<Employee1> getAllEmployee(EntityManager entityManager) {
        String jpqlQuery = "SELECT s FROM Employee1 s";
        TypedQuery<Employee1> query = entityManager.createQuery(jpqlQuery, Employee1.class);
        List<Employee1> employees = query.getResultList();
        return employees;
    }
}
