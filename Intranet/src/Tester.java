import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Tester {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("1", "Jack", "Back", 2, Faculty.FIT, Degree.BACHELOR);
        Student s2 = new Student("2", "Bob", "KKK", 3, Faculty.MCM, Degree.BACHELOR);
        Student s3 = new Student("3", "Mike", "Vaz", 4, Faculty.BS, Degree.BACHELOR);
        Student s4 = new Student("4", "Brown", "Les", 1, Faculty.FIT, Degree.BACHELOR);

//        Teacher t1 = new Teacher("5","Alimzhan","Amanov", EmployeeTypes.EDUCATIONAL, AcademicDegree.LECTURER);
//        s1.rateTeachers(t1, 4.0);
//        s2.rateTeachers(t1, 5.0);
//        System.out.print(t1.getRate());
        // Student s5 = new Student(5, "Jony", "TTT", 2, Faculty.FIT, Degree.BACHELOR);
//         Database.users.add(s1); Database.users.add(s2); Database.users.add(s3); Database.users.add(s4);
//         Database.saveUsers();
        //Database.loadUsers();
        // Database.serUsers();
        // Database.desUsers();
        //System.out.println(Database.getStudents());
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(s4);
        students.add(s2);
        students.add(s3);
        students.add(s1);
        Collections.sort(students, new SortStudentByName());
        for (Student s: students) {
        	System.out.println(s);
        }
        Admin a1 = new Admin("1", "Admin", "Admin", EmployeeTypes.ADMINISTRATION);
        Database.users.add(a1);
//        Student s5 = new Student("5", "Jony", "TTT", 2, Faculty.FIT, Degree.BACHELOR);
        Database.users.add(s1); Database.users.add(s2); Database.users.add(s3); Database.users.add(s4);
//        Database.saveUsers();
//        Database.loadUsers();
//        Course c2 = new Course("CSCI11", "PP2", 4, Faculty.FIT, t1);
//        Database.courses.add(c2);
//        c2.setStudents(s4);
//        Course c1 = new Course("CSCI12", "WebDev", 4, Faculty.FIT, t1);
//        Database.courses.add(c1);
//        t1.setCourses(c2);
//        s4.registerForCourse(c2);
//        s4.registerForCourse(c1);
        Teacher t2 = new Teacher("1", "Pakita", "Shamoi", EmployeeTypes.EDUCATIONAL, AcademicDegree.PROFESSOR);
        Course c3 = new Course("CSCI13", "OOP", 4, Faculty.FIT, t2);
        Database.courses.add(c3);
        Librarian l1 = new Librarian("10","Ernazar","Dobby",EmployeeTypes.OTHER);
        Manager m = new Manager("11","Manager","Manager",EmployeeTypes.MANAGEMENT);
        Database.users.add(m);
        Database.users.add(l1);
//        t1.setCourses(c1);
//        t2.setCourses(c1);
//        Database.users.add(t2);
//        t1.putMark(c2, TypeOfMark.FIRST_ATTESTATION, 30, s4);
//        t1.putMark(c2, TypeOfMark.SECOND_ATTESTATION, 30, s4);
//        t1.putMark(c2, TypeOfMark.FINAL, 30, s4);
//        t2.putMark(c1, TypeOfMark.FIRST_ATTESTATION, 30, s4);
//        t2.putMark(c1, TypeOfMark.SECOND_ATTESTATION, 40, s4);
//        t2.putMark(c1, TypeOfMark.FINAL, 30, s4);
//        Database.users.add(t1);
//        Manager m = new Manager("1", "Chel", "Slave", EmployeeTypes.MANAGEMENT);
//        Database.users.add(m);
//        System.out.print(c2.getStudents());
//        System.out.println(t2.getCourses());
//        s4.viewTranscript();
//        System.out.print(c2.getStudents());
//        System.out.println("teacher");
//        System.out.println(t1.getCourses());
//        System.out.println(s4.getId());
//        System.out.println("student");
//        System.out.println(s4.getCourses());
//        System.out.println(c2.getStudents());
//        System.out.println(s4.getCourses());
//        Database.saveCourses();
//        Database.saveUsers();
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
        Librarian l = new Librarian("1", "erna", "tolya", EmployeeTypes.OTHER);
        Database.users.add(l);
//        Database.saveUsers();
//        Database.saveCourses();
        CourseFiles cf = new CourseFiles("Test", "test");
//        t1.addFiles(c1, cf);
//        System.out.println(s4.viewCourseFiles(c1));
        m.addCourse(new Course("INFT2", "DJ", 3, Faculty.FIT, t2));
        System.out.println(t2.getTeachingCourses());
//        System.out.println(t1.getTeachingCourses());

//        Database.courses.add();
//        System.out.println(t1.getTeachingCourses());
//        Database.courses.add(c2);
//        Database.courses.add(c1);
//        Database.saveCourses();
        
//        t2.setCourses(c1);
        
    }
}
