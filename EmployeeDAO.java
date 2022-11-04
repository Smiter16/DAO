import java.util.List;

public interface EmployeeDAO {
    void save (Employee employee);
    Employee findById (Integer id);
    List <Employee> findByFirstName (String firstName);
    List <Employee> findByLastName (String lastName);
    List <Employee> findByGender (String gender);

}
