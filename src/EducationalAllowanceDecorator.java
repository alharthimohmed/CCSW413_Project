// طبقة البدل التربوي: تزيد الراتب فقط (ما تغير الخبرة)
public class EducationalAllowanceDecorator extends EmployeeDecorator {

    private static final int ALLOWANCE = 200;        // رقم مبدئي، غيره حسب البدل عندك

    public EducationalAllowanceDecorator(Employee employee) {
        super(employee);
    }

    @Override
    public int getSalary() {
        return employee.getSalary() + ALLOWANCE;
    }

    @Override
    public String toString() {
        return employee.toString() + " [Educational allowance]";
    }
}