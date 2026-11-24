// طبقة الماجستير: تزيد الراتب وتزيد سنوات الخبرة
public class MasterDegreeDecorator extends EmployeeDecorator {

    private static final int SALARY_BONUS = 300;     // أرقام مبدئية، غيرها حسب اللي تبغاه
    private static final int EXTRA_EXPERIENCE = 2;

    public MasterDegreeDecorator(Employee employee) {
        super(employee);
    }

    @Override
    public int getSalary() {
        return employee.getSalary() + SALARY_BONUS;
    }

    @Override
    public int getExperienceYears() {
        return employee.getExperienceYears() + EXTRA_EXPERIENCE;
    }

    @Override
    public String toString() {
        return employee.toString() + " [Master's degree]";
    }
}