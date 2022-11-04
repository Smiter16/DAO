import java.sql.*;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO {

    private static final String URL = "jdbc:mysql://localhost/managers_db";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "Smiter1!";

    @Override
    public void save(Employee employee) {

    }

    @Override
    public Employee findById(Integer id) {
        initDriver();

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("select * from employees where id = " + id);
            resultSet.next();
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setFirst_name(resultSet.getString("first_name"));
            employee.setLast_name(resultSet.getString("last_name"));
            employee.setGender(Gender.valueOf(resultSet.getString("gender")));

            return employee;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
   /*         List<Employee> employees =  ("select * from departments where department_name = '" + department_name + "'");
            resultSet.next();
            Department department = new Department();
            department.setId(resultSet.getInt("id"));
            department.setDepartment_name(resultSet.getString("department_name"));

           return department;
*/
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Employee> findByGender(String gender) {
        return null;
    }


    private static void initDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
