import java.sql.*;
import java.util.ArrayList;

public class App12_10 {



    public static void main(String[] args) throws SQLException {

        EmployeeDAOimpl employeeDAOimpl = new EmployeeDAOimpl();

        final Employee employeeById = employeeDAOimpl.findById(2);
        System.out.println("Employee by id: " + employeeById.toString());


    }
}


