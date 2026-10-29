import java.util.ArrayList;
import java.util.List;

public class School {

    private List<Teacher> teachers;
    private List<Student> students;

    public School() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }

    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
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