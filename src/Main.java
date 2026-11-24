

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating teacher objects
        Teacher john = new Teacher(1, "John Smith", 500);
        Teacher alice = new Teacher(2, "Alice Johnson", 700);
        Teacher maria = new Teacher(3, "Maria Williams", 600);

        // Creating a list of teachers and adding the teacher objects to the list
        List<Employee> teacherList = new ArrayList<>();
        teacherList.add(john);
        teacherList.add(alice);
        teacherList.add(maria);

        // Creating student objects
        Student ethan = new Student(1, "Ethan Brown", 4);
        Student olivia = new Student(2, "Olivia Davis", 12);
        Student liam = new Student(3, "Liam Wilson", 5);

        // Creating a list of students and adding the student objects to the list
        List<Student> studentList = new ArrayList<>();
        studentList.add(ethan);
        studentList.add(olivia);
        studentList.add(liam);

        // Creating a School object with the lists of teachers and students
        School ghs = new School(teacherList, studentList);

        // Adding another teacher to the school
        Teacher sophia = new Teacher(4, "Sophia Martinez", 900);
        ghs.addEmployee(sophia);

        // Students paying fees
        ethan.payFees(5000);  // Ethan pays $5000
        olivia.payFees(6000);  // Olivia pays $6000

        // Displaying total money earned by the school
        System.out.println("GHS has earned $" + ghs.getTotalMoneyEarned());

        // Making the school pay salary to teachers
        System.out.println("Making school pay salary-----");
        john.receiveSalary(john.getSalary());  // John receives his salary
        System.out.println("GHS has spent for salary to " + john.getName() + " and now has $" + ghs.getTotalMoneyEarned());

        maria.receiveSalary(maria.getSalary());  // Maria receives her salary
        System.out.println("GHS has spent for salary to " + maria.getName() + " and now has $" + ghs.getTotalMoneyEarned());

        // Displaying information about Olivia
        System.out.println(olivia);

        // Alice receives her salary
        alice.receiveSalary(alice.getSalary());
        System.out.println(alice);



        // ===================== Composite + Decorator =====================
        System.out.println("\n===== Composite & Decorator demo =====");

        // معلم عادي ننشئه من الـ Factory
        Employee omar = new TeacherCreator().creatPerson(5, "Omar Ali", 500);

        // معلمة ملفوفة بثلاث طبقات: ماجستير + بدل تربوي + دور
        Employee sara = new Teacher(6, "Sara Ahmed", 700, 3);
        sara = new MasterDegreeDecorator(sara);                       // +300 راتب، +2 خبرة
        sara = new EducationalAllowanceDecorator(sara);               // +200 راتب
        sara = new RoleDecorator(sara, "Head of Math Department");    // الدور كنص

        System.out.println("Sara salary: " + sara.getSalary());
        System.out.println("Sara experience: " + sara.getExperienceYears());
        System.out.println("Sara role: " + sara.getRole());
        System.out.println(sara);

        // مدير فريقه معلمين
        Manager khaled = new Manager(7, "Khaled Hassan", 1500, 10);
        khaled.add(omar);
        khaled.add(sara);

        // مدير أعلى فريقه فيه المدير الأول + معلمة (شجرة داخل شجرة)
        Manager principal = new Manager(8, "Principal Nasser", 2500, 15);
        principal.add(khaled);
        principal.add(new Teacher(9, "Huda Saleh", 600, 2));

        System.out.println("Principal total salary: " + principal.getTotalSalary());

        int spentBefore = ghs.getTotalMoneySpent();
        principal.paySalary();   // نداء واحد يدفع للكل
        System.out.println("Spent by paySalary(): " + (ghs.getTotalMoneySpent() - spentBefore));
    }
}
