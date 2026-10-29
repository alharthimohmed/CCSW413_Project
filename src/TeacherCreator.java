
public class TeacherCreator extends PersonCreator {
    @Override
    public Teacher creatPerson(int id, String name, int salary) {
        return new Teacher(id,name,salary);

        //اهاااا هن اللعب كله الان انا استدلت ال Person with Teacher لييييش!!؟
        //عشان اقوله ترا بسوي شخص جديد بس انتبه ترا من نوع Teacher
        // الحين لازم طبعا اروح اغير ال GUI مو كله بس بعض الاجزاء
    }
}
