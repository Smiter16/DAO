import java.sql.*;

public class DepartmentDAOimpl implements DepartmentDAO {

    private static final String URL = "jdbc:mysql://localhost/managers_db";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "Smiter1!";

    @Override
    public Department findById(Integer id) {
        initDriver();

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
             final ResultSet resultSet = statement.executeQuery("select * from departments where id = " + id);
             resultSet.next();
             Department department = new Department();
             department.setId(resultSet.getInt("id"));
             department.setDepartment_name(resultSet.getString("department_name"));

             return department;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Department findByDepartment_name(String department_name) {
        initDriver();

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("select * from departments where department_name = '" + department_name + "'");
            resultSet.next();
            Department department = new Department();
            department.setId(resultSet.getInt("id"));
            department.setDepartment_name(resultSet.getString("department_name"));

            return department;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Department department) {
        initDriver();

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into departments values (" + department.getId() + ", " +
                    "'" + department.getDepartment_name() + "'" + ")");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Integer id) {
        initDriver();

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from departments where id = " + id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Department department) {
        initDriver();

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("update departments set department_name = '" + department.getDepartment_name() + "' where id = " + department.getId() );


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void initDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

