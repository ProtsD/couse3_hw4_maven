package hw4_maven.service;

import hw4_maven.model.Employee;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void add(Employee employee, Connection connection) throws SQLException;

    Employee getById(int id, Connection connection) throws SQLException;

    void updateEmployee(int id, Employee employee, Connection connection) throws SQLException;

    void deleteById(int id, Connection connection) throws SQLException;

    List<Employee> getAllEmployee(Connection connection) throws SQLException;

}
