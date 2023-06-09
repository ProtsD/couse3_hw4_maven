package hw5_hibernate;

import hw5_hibernate.model.Employee1;
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

        for (Employee1 employee : employeeDAOImpl.getAllEmployee(entityManager)) {
            System.out.println(employee);
        }

        employeeDAOImpl.deleteById(17, entityManager);
        employeeDAOImpl.updateEmployee(17, new Employee1("Max4", "Sidorov1", "male", 22, 1), entityManager);
        employeeDAOImpl.add(new Employee1("Max5", "Sidorov1", "male", 22, 2), entityManager);
        System.out.println(employeeDAOImpl.getById(55, entityManager));
        System.out.println("****************************");
        employeeDAOImpl.updateEmployee(1,new Employee1("Max51", "Sidorov1", "male", 22, 2), entityManager);
        System.out.println("****************************");

        entityManager.close();
        entityManagerFactory.close();
    }
}
