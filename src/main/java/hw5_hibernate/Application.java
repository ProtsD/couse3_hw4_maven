package hw5_hibernate;

import hw5_hibernate.model.Employee;
import hw5_hibernate.service.EmployeeDAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

        for (Employee employee : employeeDAOImpl.getAllEmployee(entityManager)) {
            System.out.println(employee);
        }

        employeeDAOImpl.deleteById(17, entityManager);
        employeeDAOImpl.updateEmployee(17, new Employee("Max4", "Sidorov1", "male", 22, 1), entityManager);
        employeeDAOImpl.add(new Employee("Max5", "Sidorov1", "male", 22, 2), entityManager);
        System.out.println(employeeDAOImpl.getById(55, entityManager));
        System.out.println("****************************");
        employeeDAOImpl.updateEmployee(1,new Employee("Max51", "Sidorov1", "male", 22, 2), entityManager);
        System.out.println("****************************");

        entityManager.close();
        entityManagerFactory.close();
    }
}
