import java.util.ArrayList;
import java.util.Collections;


/**
 * @generated
 */
public class Manager extends Employee {

    /**
     * @generated
     */
    private ArrayList<Course> courses;

    /**
     * @generated
     */
    private ArrayList <Teacher> teachers;

    /**
     * @generated
     */
    private ArrayList <Student> students;

    private ArrayList <News> news;
    /**
     * @generated
     */

    public Manager(String id, String name, String surname, EmployeeTypes department) {
        super(id, name, surname, department);
    }

    public Manager() {

    }


    /**
     * @generated
     */
    private ArrayList <Course> getCourses() {
        return this.courses;
    }

    /**
     * @generated
     */
    private void setCourses(ArrayList <Course> courses) {
        this.courses = courses;
    }

    /**
     * @generated
     */
    public ArrayList <Teacher> getTeachers() {
        return this.teachers;
    }

    /**
     * @generated
     */
    private void setTeachers(ArrayList <Teacher> teachers) {
        this.teachers = teachers;
    }

    /**
     * @generated
     */
    private ArrayList <Student> getStudents() {
        return this.students;
    }

    /**
     * @generated
     */
    private void setStudents(ArrayList <Student> students) {
        this.students = students;
    }


    private ArrayList <News> getNews() {
        return this.news;
    }

    public void setNews(ArrayList<News> news) {
        this.news = news;
    }


    //                          Operations


//    public createStatisticalReport() {
//        //TODO
//    }

    public void addCourse(Course course) {
        courses.add(course);
//        Database.courses.add(course);
    }
    public void deleteCourse(Course course) {
        courses.remove(course);
//        Database.courses.remove(course);
    }
    public void changeLimitOfStudents(Course course, int number) {
        course.setLimitOfStudents(number);
    }
    public void changeNumberOfCredits(Course course, int number) {
        course.setCredits(number);
    }
    public void openRegistration() {
        Database.registrationIsOpen = true;
    }
    public void closeRegistration() {
        Database.registrationIsOpen = false;
    }

    public void extendRegistration() {
        if(!Database.registrationIsOpen) {
            Database.registrationIsOpen = true;
        }
    }
    public void addNews(News n) {
        news.add(n);
    }

    public void updateNews(News n, String description) {
        n.setDescription(description);
    }

    public void deleteNews(News n) {
        news.remove(n);
    }
    public ArrayList <Teacher> viewTeachersInAlphabeticOrder() {
        Collections.sort(teachers, new SortTeacherByName());
        return teachers;
    }

    public ArrayList<Course> viewTeachersCourse(Teacher teacher) {
        return teacher.getCourses();
    }

    public void viewStudentsTranscript(Student student) {
        student.viewTranscript();
    }

    public ArrayList <Student> viewStudentsInAlphabeticOrder() {
        Collections.sort(students, new SortStudentByName());
        return students;
    }
    public ArrayList<Student>viewStudentsByGPA(Course course) {
        Collections.sort(students, new SortStudentByGpa(course));
        return students;
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                '}';
    }
}
