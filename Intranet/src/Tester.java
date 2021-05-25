import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("1", "Jack", "Back", 2, Faculty.FIT, Degree.BACHELOR);
        Student s2 = new Student("2", "Bob", "KKK", 3, Faculty.MCM, Degree.BACHELOR);
        Student s3 = new Student("3", "Mike", "Vaz", 4, Faculty.BS, Degree.BACHELOR);
        Student s4 = new Student("4", "Brown", "Les", 1, Faculty.FIT, Degree.BACHELOR);
        // Student s5 = new Student(5, "Jony", "TTT", 2, Faculty.FIT, Degree.BACHELOR);
        // Database.users.add(s1); Database.users.add(s2); Database.users.add(s3); Database.users.add(s4);
        // Database.saveUsers();
        Database.loadUsers();
        // Database.serUsers();
        // Database.desUsers();
        System.out.println(Database.getStudents());
    }
}
