import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;



//انزل تحت اخر شي عشان التغيرات اللي احتاحها ل ال Factory methode اللي سويته وشكرا !!!!!!
//كمان شوف السطر 134 و 150 تغير لانه خلاص الموضوع صار يستخدم ال Factorymethode
public class SchoolManagementSystemGUI {
    private final FinanceManager finance =
            FinanceManager.getInstance();
    private School school;  // School object to manage teachers and students
    private JTextArea outputArea;  // Text area for displaying output messages
    private JComboBox<Student> studentComboBox;  // Combo box for selecting students
    private JComboBox<Employee> teacherComboBox;  // ★ تعديل: كان JComboBox<Teacher> — الحين يقبل معلم أو مدير أو معلم ملفوف بـ Decorator
    private JComboBox<Manager> managerComboBox;  // ★ جديد: قائمة المدراء (عشان نختار مدير ونضيف له فريق)

    public SchoolManagementSystemGUI() {
        // Initialize lists of teachers and students
        List<Employee> teacherList = new ArrayList<>();   // ★ تعديل: كان List<Teacher>
        List<Student> studentList = new ArrayList<>();
        school = new School(teacherList, studentList);
        initUI();  // Initialize the user interface
    }

    private void initUI() {
        // Create the main frame
        JFrame frame = new JFrame("School Management System");
        frame.setSize(600, 560);   // ★ تعديل: كبّرنا النافذة عشان الصفوف الجديدة (كانت 600, 500)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel and set layout
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // Place components on the panel
        placeComponents(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        // Add student label
        JLabel studentLabel = new JLabel("Add Student:");
        studentLabel.setBounds(10, 10, 80, 25);
        panel.add(studentLabel);

        // Add student name text field
        JTextField studentNameField = new JTextField(20);
        studentNameField.setBounds(100, 10, 160, 25);
        panel.add(studentNameField);

        // Add student grade text field
        JTextField studentGradeField = new JTextField(20);
        studentGradeField.setBounds(270, 10, 50, 25);
        panel.add(studentGradeField);

        // Add student button
        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.setBounds(330, 10, 150, 25);
        panel.add(addStudentButton);

        // Add teacher label
        JLabel teacherLabel = new JLabel("Add Teacher:");
        teacherLabel.setBounds(10, 40, 80, 25);
        panel.add(teacherLabel);

        // Add teacher name text field
        JTextField teacherNameField = new JTextField(20);
        teacherNameField.setBounds(100, 40, 160, 25);
        panel.add(teacherNameField);

        // Add teacher salary text field
        JTextField teacherSalaryField = new JTextField(20);
        teacherSalaryField.setBounds(270, 40, 50, 25);
        panel.add(teacherSalaryField);

        // Add teacher button
        JButton addTeacherButton = new JButton("Add Teacher");
        addTeacherButton.setBounds(330, 40, 150, 25);
        panel.add(addTeacherButton);

        // ★ جديد: خيارات المعلم (Decorator) — ماجستير، بدل تربوي، ودور كنص
        JCheckBox masterCheckBox = new JCheckBox("Master's degree");
        masterCheckBox.setBounds(10, 70, 130, 25);
        panel.add(masterCheckBox);

        JCheckBox allowanceCheckBox = new JCheckBox("Edu. allowance");
        allowanceCheckBox.setBounds(145, 70, 130, 25);
        panel.add(allowanceCheckBox);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(285, 70, 40, 25);
        panel.add(roleLabel);

        JTextField roleField = new JTextField(20);
        roleField.setBounds(330, 70, 150, 25);
        panel.add(roleField);

        // ★ جديد: صف إضافة مدير (Composite)
        JLabel managerLabel = new JLabel("Add Manager:");
        managerLabel.setBounds(10, 100, 90, 25);
        panel.add(managerLabel);

        JTextField managerNameField = new JTextField(20);
        managerNameField.setBounds(100, 100, 160, 25);
        panel.add(managerNameField);

        JTextField managerSalaryField = new JTextField(20);
        managerSalaryField.setBounds(270, 100, 50, 25);
        panel.add(managerSalaryField);

        JButton addManagerButton = new JButton("Add Manager");
        addManagerButton.setBounds(330, 100, 150, 25);
        panel.add(addManagerButton);

        // Add select student label
        JLabel selectStudentLabel = new JLabel("Select Student:");
        selectStudentLabel.setBounds(10, 130, 100, 25);   // ★ تعديل: نزلنا الصف (كان y=70)
        panel.add(selectStudentLabel);

        // Add student combo box
        studentComboBox = new JComboBox<>();
        studentComboBox.setBounds(120, 130, 160, 25);   // ★ تعديل: نزلنا الصف (كان y=70)
        panel.add(studentComboBox);

        // Add pay fees button
        JButton payFeesButton = new JButton("Pay Fees");
        payFeesButton.setBounds(290, 130, 100, 25);   // ★ تعديل: نزلنا الصف (كان y=70)
        panel.add(payFeesButton);

        // Add select teacher label
        JLabel selectTeacherLabel = new JLabel("Select Employee:");   // ★ تعديل: كان "Select Teacher:" لأن القائمة صارت تشمل المدراء
        selectTeacherLabel.setBounds(10, 160, 110, 25);   // ★ تعديل: نزلنا الصف وكبّرنا العرض (كان 10, 100, 100, 25)
        panel.add(selectTeacherLabel);

        // Add teacher combo box
        teacherComboBox = new JComboBox<>();
        teacherComboBox.setBounds(120, 160, 160, 25);   // ★ تعديل: نزلنا الصف (كان y=100)
        panel.add(teacherComboBox);

        // Add pay salary button
        JButton paySalaryButton = new JButton("Pay Salary");
        paySalaryButton.setBounds(290, 160, 100, 25);   // ★ تعديل: نزلنا الصف (كان y=100)
        panel.add(paySalaryButton);

        // ★ جديد: صف المدير والفريق (Composite)
        JLabel selectManagerLabel = new JLabel("Select Manager:");
        selectManagerLabel.setBounds(10, 190, 110, 25);
        panel.add(selectManagerLabel);

        managerComboBox = new JComboBox<>();
        managerComboBox.setBounds(120, 190, 160, 25);
        panel.add(managerComboBox);

        JButton addToTeamButton = new JButton("Add to Team");
        addToTeamButton.setBounds(290, 190, 120, 25);
        panel.add(addToTeamButton);

        JButton teamTotalButton = new JButton("Team Total");
        teamTotalButton.setBounds(420, 190, 120, 25);
        panel.add(teamTotalButton);

        // Add output area with scroll pane
        outputArea = new JTextArea();
        outputArea.setEditable(false);  // Make the text area non-editable

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(10, 230, 560, 250);   // ★ تعديل: نزلنا منطقة الطباعة (كانت 10, 140, 560, 300)
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);

        // Add action listener for adding students
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = studentNameField.getText();
                int grade = Integer.parseInt(studentGradeField.getText());
                int id = school.getStudents().size() + 1;
//                Student student = new Student(id, name, grade);
                Student student =
                        studentCreator.creatPerson(id, name, grade);
                school.addStudent(student);
                studentComboBox.addItem(student);
                outputArea.append("Added student: " + name + " (Grade: " + grade + ")\n");
            }
        });

        // Add action listener for adding teachers
        addTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = teacherNameField.getText();
                int salary = Integer.parseInt(teacherSalaryField.getText());
                int id = school.getEmployees().size() + 1;   // ★ تعديل: كان getTeachers()
//                Teacher teacher = new Teacher(id, name, salary);

                // ★ تعديل: الـ Factory ينشئ المعلم الأساسي (المتغير صار Employee بدل Teacher)
                Employee employee = teacherCreator.creatPerson(id, name, salary);

                // ★ جديد: الـ Decorator — نلف المعلم بطبقات حسب اللي اختاره المستخدم
                if (masterCheckBox.isSelected()) {
                    employee = new MasterDegreeDecorator(employee);
                }
                if (allowanceCheckBox.isSelected()) {
                    employee = new EducationalAllowanceDecorator(employee);
                }
                String role = roleField.getText().trim();
                if (!role.isEmpty()) {
                    employee = new RoleDecorator(employee, role);
                }

                school.addEmployee(employee);            // ★ تعديل: كان school.addTeacher(teacher)
                teacherComboBox.addItem(employee);
                // ★ تعديل: الرسالة الحين تعرض الراتب النهائي والخبرة والدور بعد الـ Decorators
                outputArea.append("Added teacher: " + name
                        + " (Salary: " + employee.getSalary()
                        + ", Experience: " + employee.getExperienceYears()
                        + ", Role: " + employee.getRole() + ")\n");
            }
        });

        // ★ جديد: زر إضافة مدير (Composite) — ينشئه الـ Factory
        addManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = managerNameField.getText();
                int salary = Integer.parseInt(managerSalaryField.getText());
                int id = school.getEmployees().size() + 1;

                Manager manager = managerCreator.creatPerson(id, name, salary);   // من الـ Factory
                school.addEmployee(manager);
                teacherComboBox.addItem(manager);   // عشان نقدر ندفع له راتبه (ويندفع معاه فريقه)
                managerComboBox.addItem(manager);   // عشان نقدر نضيف له فريق
                outputArea.append("Added manager: " + name + " (Salary: " + salary + ")\n");
            }
        });

        // ★ جديد: زر إضافة الموظف المختار لفريق المدير المختار (Composite)
        addToTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager manager = (Manager) managerComboBox.getSelectedItem();
                Employee employee = (Employee) teacherComboBox.getSelectedItem();

                if (manager == null || employee == null) {
                    outputArea.append("Select a manager and an employee first\n");
                    return;
                }

                try {
                    manager.add(employee);   // Composite: المدير يضيف الموظف لفريقه
                    outputArea.append(employee.getName() + " added to " + manager.getName() + "'s team\n");
                } catch (IllegalArgumentException ex) {
                    outputArea.append(ex.getMessage() + "\n");
                }
            }
        });

        // ★ جديد: زر عرض الفريق ومجموع الرواتب (Composite)
        teamTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager manager = (Manager) managerComboBox.getSelectedItem();

                if (manager != null) {
                    StringBuilder members = new StringBuilder();
                    for (Employee member : manager.getTeam()) {
                        if (members.length() > 0) {
                            members.append(", ");
                        }
                        members.append(member.getName());
                    }
                    String team = members.length() == 0 ? "(empty)" : members.toString();

                    outputArea.append("Team of " + manager.getName() + ": " + team + "\n");
                    outputArea.append("Total salary for " + manager.getName() + " and the team: $"
                            + manager.getTotalSalary() + "\n");
                }
            }
        });

        // Add action listener for paying fees
        payFeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = (Student) studentComboBox.getSelectedItem();
//                if (student != null) {
//                    student.payFees(1000);  // Example amount
//                    outputArea.append(student.getName() + " paid fees. Total fees paid: $" + student.getFeesPaid() + "\n");
//                    outputArea.append("Total money earned by school: $" + school.getTotalMoneyEarned() + "\n");
//                }
                try{
                    student.payFees(1000);
                    outputArea.append(
                            student.getName()+"Paid fees, Tota; Paid: $"+student.getFeesPaid()+"\n"
                    );
                    outputArea.append(
                            "Total money earned by school: $"
                                    + finance.getTotalMoneyEarned() +"The Total School Mony : "+finance.getBalance()+ "\n"
                    );
                } catch (IllegalArgumentException ex){
                    outputArea.append(ex.getMessage()+"\n");
                }


            }
        });

        // Add action listener for paying salary
        paySalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Teacher teacher = (Teacher) teacherComboBox.getSelectedItem();
//                if (teacher != null) {
//                    teacher.receiveSalary(teacher.getSalary());
//                    outputArea.append("Paid salary to: " + teacher.getName() + ". Total salary earned: $" + teacher.getSalary() + "\n");
//                    outputArea.append("Total money spent by school: $" + school.getTotalMoneySpent() + "\n");
//                    outputArea.append("Remaining money in school: $" + (school.getTotalMoneyEarned() - school.getTotalMoneySpent()) + "\n");
                // ★ تعديل: كان Teacher، الحين Employee عشان يقبل معلم أو مدير أو معلم ملفوف بـ Decorator
                Employee employee = (Employee) teacherComboBox.getSelectedItem();

                if (employee != null) {
                    try {
                        // ★ تعديل: كان teacher.receiveSalary(teacher.getSalary())
                        // paySalary(): المعلم يدفع لنفسه، والمعلم الملفوف يدفع راتبه مع البدلات، والمدير يدفع لنفسه ولكل فريقه
                        employee.paySalary();

                        outputArea.append(
                                "Paid salary to: " + employee.getName() + " (" + employee.getRole() + ")\n"
                        );

                        outputArea.append(
                                "Total money spent: $"
                                        + finance.getTotalMoneySpent() + "\n"
                        );

                        outputArea.append(
                                "Remaining school balance: $"
                                        + finance.getBalance() + "\n"
                        );

                    } catch (IllegalArgumentException ex) {
                        outputArea.append(ex.getMessage() + "\n");
                    }


                }
            }
        });
    }

    private final StudentCreator studentCreator =
            new StudentCreator();

    private final TeacherCreator teacherCreator =
            new TeacherCreator();

    // ★ جديد: Factory Method للمدير (نفس فكرة studentCreator و teacherCreator)
    private final ManagerCreator managerCreator =
            new ManagerCreator();

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SchoolManagementSystemGUI();
            }
        });


//        FinanceManager f1 = FinanceManager.getInstance();
//        FinanceManager f2 = FinanceManager.getInstance();
//
//        System.out.println(f1 == f2);
//
//        f1.recordFees(5000);
//        f2.recordSalary(2000);
//
//        System.out.println(f1.getBalance());
//        System.out.println(f2.getBalance());

    }
}