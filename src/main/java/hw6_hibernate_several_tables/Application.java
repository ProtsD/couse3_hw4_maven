package hw6_hibernate_several_tables;

import hw6_hibernate_several_tables.model.City;
import hw6_hibernate_several_tables.model.Employee;
import hw6_hibernate_several_tables.service.CityDAOImpl;
import hw6_hibernate_several_tables.service.EmployeeDAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
        CityDAOImpl cityDAOImpl = new CityDAOImpl();

        for (Employee employee : employeeDAOImpl.getAllEmployee(entityManager)) {
            System.out.println(employee);
        }

        employeeDAOImpl.deleteById(19, entityManager);
        employeeDAOImpl.updateEmployee( new Employee("Max14", "Sidorov1", "male", 22, null), entityManager);
        employeeDAOImpl.add(new Employee("Max5", "Sidorov1", "male", 22, null), entityManager);
        System.out.println(employeeDAOImpl.getById(55, entityManager));
        System.out.println("****************************");
        employeeDAOImpl.updateEmployee(new Employee("Max51", "Sidorov1", "male", 22, null), entityManager);
        System.out.println("****************************");

        cityDAOImpl.deleteById(5, entityManager);
        cityDAOImpl.updateCity(new City(7,"Don2"), entityManager);
        cityDAOImpl.add(new City("Don"), entityManager);
        System.out.println(cityDAOImpl.getById(6, entityManager));
        System.out.println("****************************");
        cityDAOImpl.updateCity(new City(7,"Don3"), entityManager);
        System.out.println("****************************");

        entityManager.close();
        entityManagerFactory.close();
    }
}
