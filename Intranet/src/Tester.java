public class Tester {
    public static void main(String[] args) {
        Student s4 = new Student("4", "Brown", "Les", 1, Faculty.FIT, Degree.BACHELOR);
        Teacher t1 = new Teacher("5","Teacher","Teacher", EmployeeTypes.EDUCATIONAL, AcademicDegree.LECTURER);
        Admin a1 = new Admin("1", "Admin", "Admin", EmployeeTypes.ADMINISTRATION);
        Database.users.add(t1);
        Database.users.add(s4);
        Database.users.add(a1);
        News n1 = new News("test", "test");
        Database.news.add(n1);
        Database.saveNews();
        Database.saveUsers();
        Database.saveCourses();
    }
}
