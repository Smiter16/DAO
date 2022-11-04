public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private Gender gender;

    public Employee(int id, String first_name, String last_name, Gender gender) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
    }
    public Employee() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{ " +
                "id= " + id +
                ", first_name= '" + first_name + '\'' +
                ", last_name= '" + last_name + '\'' +
                ", gender= " + gender +
                '}';
    }
}
