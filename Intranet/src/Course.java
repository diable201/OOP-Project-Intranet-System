import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
* @generated
*/
public class Course implements Serializable {
    
    /**
    * @generated
    */
    private String code;
    
    /**
    * @generated
    */
    private String title;
    
    /**
    * @generated
    */
    private Integer credits;
    
    /**
    * @generated
    */
    private HashSet <CourseFiles> courseFiles;
    
    /**
    * @generated
    */
    private Integer limitOfStudents;
    
    /**
    * @generated
    */
    private ArrayList<Lesson> lessons;
    
    /**
    * @generated
    */
    private HashSet<Course> prerequisites;
    
    /**
    * @generated
    */
    private ArrayList <Student> students;
    
    /**
    * @generated
    */
    private HashMap<Student, Mark> marks;
    
    
    /**
    * @generated
    */
    private CourseFiles courseFiles2;
    
    /**
    * @generated
    */
    private Teacher teacher;
    
    /**
    * @generated
    */
    private Lesson lesson;
    
    /**
    * @generated
    */
    private Student student;
    
    
    /**
    * @generated
    */
    private String getCode() {
        return this.code;
    }
    
    /**
    * @generated
    */
    private void setCode(String code) {
        this.code = code;
    }
    
    /**
    * @generated
    */
    private String getTitle() {
        return this.title;
    }
    
    /**
    * @generated
    */
    private void setTitle(String title) {
        this.title = title;
    }
    
    /**
    * @generated
    */
    private Integer getCredits() {
        return this.credits;
    }
    
    /**
    * @generated
    */
    private void setCredits(Integer credits) {
        this.credits = credits;
    }
    
    /**
    * @generated
    */
    private HashSet <CourseFiles> getCourseFiles() {
        return this.courseFiles;
    }
    
    /**
    * @generated
    */
    private void setCourseFiles(HashSet <CourseFiles> courseFiles) {
        this.courseFiles = courseFiles;
    }
    
    /**
    * @generated
    */
    private Integer getLimitOfStudents() {
        return this.limitOfStudents;
    }
    
    /**
    * @generated
    */
    private void setLimitOfStudents(Integer limitOfStudents) {
        this.limitOfStudents = limitOfStudents;
    }
    
    /**
    * @generated
    */
    private ArrayList <Lesson> getLessons() {
        return this.lessons;
    }
    
    /**
    * @generated
    */
    private void setLessons(ArrayList <Lesson> lessons) {
        this.lessons = lessons;
    }
    
    /**
    * @generated
    */
    private HashSet <Course> getPrerequisites() {
        return this.prerequisites;
    }
    
    /**
    * @generated
    */
    private void setPrerequisites(HashSet <Course> prerequisites) {
        this.prerequisites = prerequisites;
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
    
    /**
    * @generated
    */
    private HashMap <Student, Mark> getMarks() {
        return this.marks;
    }
    
    /**
    * @generated
    */
    private void setMarks(HashMap <Student, Mark> marks) {
        this.marks = marks;
    }
    
    /**
    * @generated
    */
    public Lesson getLesson() {
        return this.lesson;
    }
    
    /**
    * @generated
    */
    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
    
    /**
    * @generated
    */
    public Teacher getTeacher() {
        return this.teacher;
    }
    
    /**
    * @generated
    */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    /**
    * @generated
    */
    public Student getStudent() {
        return this.student;
    }
    
    /**
    * @generated
    */
    public void setStudent(Student student) {
        this.student = student;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
//    public getCode() {
//        //TODO
//    }
//    /**
//    * @generated
//    */
//    public setCode() {
//        //TODO
//    }
//    /**
//    * @generated
//    */
//    public getTitle() {
//        //TODO
//    }
//    /**
//    * @generated
//    */
//    public setTitle() {
//        //TODO
//    }
//    /**
//    * @generated
//    */
//    public getCredits() {
//        //TODO
//    }
//    /**
//    * @generated
//    */
//    public setCredits() {
//        //TODO
//    }
//    /**
//    * @generated
//    */
//    public getCourseFile() {
//        //TODO
//    }
//    /**
//    * @generated
//    */
//    public getLessons() {
//        //TODO
//    }
//    /**
//    * @generated
//    */
//    public setLessons() {
//        //TODO
//    }
    
}
