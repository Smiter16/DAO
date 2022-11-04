public interface DepartmentDAO {
    //CRUD
    Department findById (Integer id);
    Department findByDepartment_name (String department_name);
    void save (Department department);
    void delete (Integer id);
    void  update (Department department);
}
