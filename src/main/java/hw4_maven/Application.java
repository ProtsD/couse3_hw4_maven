package hw4_maven;

import hw4_maven.model.Employee;
import hw4_maven.model.City;
import hw4_maven.service.EmployeeDAOImpl;

import java.sql.*;

public class Application {
    public static void main(String[] args) {
        String query = "SELECT first_name, last_name, gender, city.city_name FROM employee " +
                "JOIN city ON employee.city_id = city.city_id WHERE id = (?)";

        try (final Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, 5);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println(
                        "first_name=" + resultSet.getString(1) +
                                " | last_name=" + resultSet.getString("last_name") +
                                " | gender=" + resultSet.getString(3) +
                                " | city_id=" + resultSet.getString(4)
                );
            }

            System.out.println("*********** Exercise 2 ***********");

            EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
            for (Employee employee : employeeDAOImpl.getAllEmployee(connection)) {
                System.out.println(employee);
            }

            employeeDAOImpl.deleteById(13, connection);
            employeeDAOImpl.updateEmployee(12, new Employee(1, "Max3", "Sidorov1", "male", 22, new City(1,"Omsk")), connection);
            employeeDAOImpl.add(new Employee(1, "Max2", "Sidorov1", "male", 22, new City(2,"Omsk")), connection);

            System.out.println();
            System.out.print("Get: ");
            System.out.println(employeeDAOImpl.getById(5, connection));
        } catch (SQLException e) {
            System.out.println("Database connection error!");
            e.printStackTrace();
        }
    }

    static Connection getConnection() throws SQLException {
        final String user = "postgres";
        final String psw = "tpmdb";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        Connection connection = DriverManager.getConnection(url, user, psw);
        return connection;
    }
}
