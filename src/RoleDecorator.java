// طبقة الدور: تستقبل الدور كنص (مثل "Head of Math Department")
// وتظهره مع الموظف، وما تغير الراتب ولا الخبرة
public class RoleDecorator extends EmployeeDecorator {

    private final String role;

    public RoleDecorator(Employee employee, String role) {
        super(employee);
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be empty");
        }
        this.role = role;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return employee.toString() + " [Role: " + role + "]";
    }
}