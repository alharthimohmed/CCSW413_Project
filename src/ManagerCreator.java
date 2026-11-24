// نفس فكرة StudentCreator و TeacherCreator: الـ Factory Method للمدير
public class ManagerCreator extends PersonCreator {
    @Override
    public Manager creatPerson(int id, String name, int salary) {
        return new Manager(id, name, salary, 0);   // الخبرة تبدأ من صفر
    }
}