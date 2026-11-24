public class StudentNode implements SchoolComponent {

    private final Student student;

    public StudentNode(Student student) {
        this.student = student;
    }



    @Override
    public String getDetails(String indent) {
        return indent + "Student"+ student.getName()
                + "ID:"+ student.getId() +"\n";
    }
}
