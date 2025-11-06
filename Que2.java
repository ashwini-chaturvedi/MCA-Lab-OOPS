class Employee{
    int id;
    String name;
    String designation;
    double salary;

    Employee(int id) {
        this.id = id;
    }
    Employee(int id, String name) {
        this(id);
        this.name = name;
    }
    Employee(int id, String name, String designation) {
        this(id, name);
        this.designation = designation;
    }
    Employee(int id, String name, String designation, double salary) {
        this(id, name, designation);
        this.salary = salary;
    }
}
public class Que2 {
    public static void main(String[] args) {

    }
}
