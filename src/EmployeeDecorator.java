// الأب لكل الـ Decorators
// يلف موظف ويمرر له كل الدوال، والطبقات الفرعية تعدل بس اللي تحتاجه
public abstract class EmployeeDecorator implements Employee {

    protected final Employee employee;   // الموظف الملفوف داخل الطبقة

    protected EmployeeDecorator(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int getId() {
        return employee.getId();
    }

    @Override
    public String getName() {
        return employee.getName();
    }

    @Override
    public int getSalary() {
        return employee.getSalary();
    }

    @Override
    public int getExperienceYears() {
        return employee.getExperienceYears();
    }

    // مهم: لازم يمرر الدور، وإلا لو لفيت طبقة فوق RoleDecorator يضيع الدور
    @Override
    public String getRole() {
        return employee.getRole();
    }

    // الـ Decorator يلف معلم (ورقة)، فمجموعه هو راتبه النهائي
    @Override
    public int getTotalSalary() {
        return getSalary();
    }

    @Override
    public void receiveSalary(int amount) {
        employee.receiveSalary(amount);
    }

    // مهم: المعلم الأصلي يعرف راتبه الأساسي بس،
    // فهنا نحسب الراتب النهائي (مع كل البدلات) ونعطيه للمعلم يسجله في FinanceManager
    @Override
    public void paySalary() {
        employee.receiveSalary(getSalary());
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}