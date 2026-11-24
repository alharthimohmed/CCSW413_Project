import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
// المدير هو الـ Composite: موظف عادي لكن يحمل قائمة موظفين تحته
// الفريق ممكن يكون معلمين أو معلمين ملفوفين بـ Decorator أو حتى مدراء ثانيين
public class Manager implements Employee {
    private int id;
    private String name;
    private int salary;
    private int salaryEarned;
    private int experienceYears;
    private List<Employee> team = new ArrayList<>();   // فريق المدير

    public Manager(int id, String name, int salary, int experienceYears) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.salaryEarned = 0;
        this.experienceYears = experienceYears;
    }

    // إضافة وحذف موظف من الفريق (موجودة في المدير فقط لأن المعلم ما يحتاجها)
    // إضافة وحذف موظف من الفريق (موجودة في المدير فقط لأن المعلم ما يحتاجها)
    public void add(Employee employee) {
        if (employee == this) {
            throw new IllegalArgumentException("A manager can't be in his own team");
        }
        if (team.contains(employee)) {
            throw new IllegalArgumentException(employee.getName() + " is already in this team");
        }
        // نمنع الدوران: ما نضيف مدير لو هذا المدير نفسه داخل فريقه (مباشرة أو بشكل غير مباشر)
        if (employee instanceof Manager && ((Manager) employee).contains(this)) {
            throw new IllegalArgumentException("Can't add " + employee.getName() + ": it would create a loop");
        }
        team.add(employee);
    }

    // true لو الموظف داخل الفريق، أو داخل فريق أي مدير تحته
    public boolean contains(Employee employee) {
        for (Employee member : team) {
            if (member == employee) {
                return true;
            }
            if (member instanceof Manager && ((Manager) member).contains(employee)) {
                return true;
            }
        }
        return false;
    }

    // نسخة للقراءة فقط من الفريق (عشان الـ GUI يعرض الأسماء)
    public List<Employee> getTeam() {
        return Collections.unmodifiableList(team);
    }

    public void remove(Employee employee) {
        team.remove(employee);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    // راتبه + مجموع كل فريقه
    // لو في مدير داخل الفريق ينادي نفس الدالة عنده، وهذي فكرة الـ Composite
    @Override
    public int getTotalSalary() {
        int total = salary;
        for (Employee employee : team) {
            total += employee.getTotalSalary();
        }
        return total;
    }

    // نفس منطق المعلم: يسجل المبلغ في FinanceManager
    @Override
    public void receiveSalary(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid salary amount");
        }

        FinanceManager.getInstance().recordSalary(amount);
        salaryEarned += amount;
    }

    // يدفع لنفسه، وبعدها كل واحد في فريقه يدفع لنفسه
    @Override
    public void paySalary() {
        receiveSalary(getSalary());
        for (Employee employee : team) {
            employee.paySalary();
        }
    }

    @Override
    public String toString() {
        return "Manager's name: " + name + ", Total salary earned so far: $" + salaryEarned;
    }
}