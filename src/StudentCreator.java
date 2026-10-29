

public class StudentCreator extends PersonCreator {
    @Override
    public Student creatPerson(int id, String name, int grade) {
        return  new Student(id,name,grade);
        //اهاااا هن اللعب كله الان انا استدلت ال Person with Student لييييش!!؟
        //عشان اقوله ترا بسوي شخص جديد بس انتبه ترا من نوع Student
    }
}
