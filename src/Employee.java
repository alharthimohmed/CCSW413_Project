// الواجهة المشتركة لكل الموظفين (معلم، مدير، وكل الـ Decorators)
public interface Employee extends Person {
    int getSalary();                 // الراتب
    int getExperienceYears();        // سنوات الخبرة
    int getTotalSalary();            // المعلم: راتبه فقط، المدير: راتبه + رواتب كل فريقه
    void receiveSalary(int amount);  // استلام راتب بمبلغ محدد (ويتسجل في FinanceManager)
    void paySalary();                // دفع الراتب: المعلم لنفسه، المدير لنفسه ولكل فريقه

    // الدور الوظيفي كنص، القيمة الافتراضية "Employee"
    // استخدمت default عشان ما أضطر أعدل في Teacher و Manager
    default String getRole() {
        return "Employee";
    }
}