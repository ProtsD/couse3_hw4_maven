package service;

import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAOImpl implements EmployeeDAO {
    private String user = "postgres";
    private String psw = "tpmdb";
    private String url = "jdbc:postgresql://localhost:5432/skypro";
    Scanner scanner = new Scanner(System.in);

    private PreparedStatement statement;

    @Override
    public void add(Employee employee, Connection connection) throws SQLException {

        statement = connection.prepareStatement(
                "INSERT INTO employee (first_name,last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?));");
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getSecondName());
        statement.setString(3, employee.getGender());
        statement.setInt(4, employee.getAge());
        statement.setInt(5, employee.getCity().getId());
        statement.execute();
        statement.executeUpdate();
    }

    @Override
    public Employee getById(int id, Connection connection) throws SQLException {
        Employee employee = new Employee();
        statement = connection.prepareStatement(
                "SELECT * FROM employee JOIN city ON employee.city_id = city.city_id WHERE id = (?)");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            employee.setId(resultSet.getInt(1));
            employee.setFirstName(resultSet.getString(2));
            employee.setSecondName(resultSet.getString(3));
            employee.setGender(resultSet.getString(4));
            employee.setAge(resultSet.getInt(5));
            employee.setCity(new City((resultSet.getInt("city_id")), resultSet.getString("city_name")));
        }
        return employee;
    }

    @Override
    public void updateEmployee(int id, Employee employee, Connection connection) throws SQLException {
        statement = connection.prepareStatement(
                "UPDATE employee SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id =(?)  " +
                        "WHERE id = (?)");
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getSecondName());
        statement.setString(3, employee.getGender());
        statement.setInt(4, employee.getAge());
        statement.setInt(5, employee.getCity().getId());
        statement.setInt(6, id);
        statement.executeUpdate();
    }

    @Override
    public void deleteById(int id, Connection connection) throws SQLException {
        statement = connection.prepareStatement("DELETE FROM employee WHERE id = (?)");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public List<Employee> getAllEmployee(Connection connection) throws SQLException {

        List<Employee> employeeList = new ArrayList<>();

        statement = connection.prepareStatement("SELECT * FROM employee JOIN city ON employee.city_id = city.city_id");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String firstName = resultSet.getString(2);
            String secondName = resultSet.getString(3);
            String gender = resultSet.getString(4);
            int age = resultSet.getInt(5);
            City city = new City(resultSet.getInt("city_id"), resultSet.getString("city_name"));
            employeeList.add(new Employee(id, firstName, secondName, gender, age, city));
        }

        return employeeList;
    }
}
