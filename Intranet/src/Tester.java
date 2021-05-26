import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("1", "Jack", "Back", 2, Faculty.FIT, Degree.BACHELOR);
        Student s2 = new Student("2", "Bob", "KKK", 3, Faculty.MCM, Degree.BACHELOR);
        Student s3 = new Student("3", "Mike", "Vaz", 4, Faculty.BS, Degree.BACHELOR);
        Student s4 = new Student("4", "Brown", "Les", 1, Faculty.FIT, Degree.BACHELOR);

        Teacher t1 = new Teacher("5","Alimzhan","Amanov", EmployeeTypes.EDUCATIONAL, AcademicDegree.LECTURER);
        s1.rateTeachers(t1, 4.0);
        s2.rateTeachers(t1, 5.0);
        System.out.print(t1.getRate());
        // Student s5 = new Student(5, "Jony", "TTT", 2, Faculty.FIT, Degree.BACHELOR);
//         Database.users.add(s1); Database.users.add(s2); Database.users.add(s3); Database.users.add(s4);
//         Database.saveUsers();
        //Database.loadUsers();
        // Database.serUsers();
        // Database.desUsers();
        //System.out.println(Database.getStudents());
        Admin a1 = new Admin("1", "Admin", "Admin", EmployeeTypes.ADMINISTRATION);
        Database.users.add(a1);
//        Student s5 = new Student("5", "Jony", "TTT", 2, Faculty.FIT, Degree.BACHELOR);
        Database.users.add(s1); Database.users.add(s2); Database.users.add(s3); Database.users.add(s4);
        Database.saveUsers();
//        Database.loadUsers();
        Course c2 = new Course("CSCI11", "PP2", 4, Faculty.FIT);
        Database.courses.add(c2);
        c2.setStudents(s4);
        Database.saveCourses();
//        Course OOP = new Course("CS1", "Object-Oriented Programming and Design", 3);
//        Course ADS = new Course("CS2", "Algorithms and Data Structures", 3);
//        Course DB = new Course("CS3", "Databases", 3);
//        Course ICT = new Course("CS4", "Information and Communication Technologies", 3);
//        Course PP2 = new Course("CS5", "Programming principles 2", 4);
//        Course PP1 = new Course("CS6", "Programming principles 1", 4);
//        Database.courses.add(PP1); Database.courses.add(PP2); Database.courses.add(OOP); Database.courses.add(DB); Database.courses.add(ADS); Database.courses.add(ICT);
//        Database.saveCourses();
//        Database.loadCourses();
//        System.out.println(Database.getStudents());
//        s1.increaseYearOfStudy();
//        System.out.println(s1);
//        Database.users.add(s1);
//        Database.saveUsers();
//        Database.loadUsers();
//        System.out.println(Database.getStudents());
//        System.out.println(Database.getAdmins());
//        System.out.println(Database.getCourses());
        Teacher t2 = new Teacher("1", "Pakita", "Shamoi", EmployeeTypes.EDUCATIONAL, AcademicDegree.PROFESSOR);
        Database.users.add(t2);
        Database.saveUsers();
    }
}
