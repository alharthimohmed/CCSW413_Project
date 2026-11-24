
/**
 * This class represents a teacher in the school system.
 * It keeps track of teacher's ID, name, salary, and salary earned.
 */
public class Teacher implements Employee {
    private int id;
    private String name;
    private int salary;
    private int salaryEarned;

    //
   // مهم ببكومبوزيت و الديكرينر
    private int experienceYears;



    /**
     * Constructor to create a new teacher with initial values.
     * @param id Unique identifier for the teacher.
     * @param name Name of the teacher.
     * @param salary Salary of the teacher.
     */
    public Teacher(int id, String name, int salary) {
        this(id, name, salary, 0);   // الكونستركتر القديم خليته عشان TeacherCreator ما ينكسر، والخبرة تبدأ من صفر
    }

    public Teacher(int id, String name, int salary, int experienceYears) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.salaryEarned = 0;
        this.experienceYears = experienceYears;
    }

    /**
     * Getter method to retrieve the teacher's ID.
     * @return Teacher's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter method to retrieve the teacher's name.
     * @return Teacher's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to retrieve the teacher's salary.
     * @return Teacher's salary.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Setter method to set the teacher's salary.
     * @param salary New salary to be set.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Method for the teacher to receive their salary.
     * @param salary Salary amount to be received.
     */
//    public void receiveSalary(int salary) {
//        salaryEarned += salary; // Add received salary to salaryEarned
//        School.updateTotalMoneySpent(salary); // Update total money spent by the school
//    }

    @Override
    public void receiveSalary(int salary) {

        if (salary <= 0) {
            throw new IllegalArgumentException("Invalid salary amount");
        }

        FinanceManager finance = FinanceManager.getInstance();

        finance.recordSalary(salary);

        salaryEarned += salary;
    }
    @Override
    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String getRole() {
        return "Teacher";
    }

    // المعلم "ورقة" (Leaf) في الشجرة، فمجموعه هو راتبه فقط
    @Override
    public int getTotalSalary() {
        return getSalary();
    }

    // يدفع لنفسه راتبه
    @Override
    public void paySalary() {
        receiveSalary(getSalary());
    }







    /**
     * Override of toString method to provide a string representation of the teacher object.
     * @return String representation of the teacher's name and total salary earned.
     */
    @Override
    public String toString() {
        return "Teacher's name: " + name + ", Total salary earned so far: $" + salaryEarned;
    }
}
