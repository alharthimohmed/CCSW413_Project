import java.util.ArrayList;
import java.util.List;

public class School {

    // القائمة الحين تحمل Employee: معلم، مدير، أو معلم ملفوف بـ Decorator
    private List<Employee> employees;
    private List<Student> students;

    public School() {
        employees = new ArrayList<>();
        students = new ArrayList<>();
    }

    public School(List<Employee> employees, List<Student> students) {
        this.employees = employees;
        this.students = students;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int getTotalMoneyEarned() {
        return FinanceManager.getInstance().getTotalMoneyEarned();
    }

    public int getTotalMoneySpent() {
        return FinanceManager.getInstance().getTotalMoneySpent();
    }
}