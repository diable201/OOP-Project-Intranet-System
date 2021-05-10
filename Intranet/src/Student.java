import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


/**
 * @generated
 */
public class Student extends User {

    /**
     * 
     */
    private static final long serialVersionUID = 2500835407927764942L;

    /**
     * @generated
     */
    private Integer yearOfStudy;

    /**
     * @generated
     */
    private ArrayList<Course> courses;

    /**
     * @generated
     */
    private Faculty faculty;

    /**
     * @generated
     */
    private Degree degree;

    /**
     * @generated
     */
    private Integer creditLimit;

    /**
     * @generated
     */
    private Integer totalCredits;

    /**
     * @generated
     */
    private HashMap<Course, Mark> marks;

  
    /**
     * @generated
     */
    
    private Integer currentYearOfStudy = 1;
    
    public Student() {
        super();
    }
    
    public Student(Integer yearOfStudy, Faculty faculty, Degree degree) {
        super();
        this.yearOfStudy = yearOfStudy;
        this.faculty = faculty;
        this.degree = degree;
    }
    public Student(Integer yearOfStudy,ArrayList<Course> courses,Degree degree,Integer creditLimit,Integer totalCredits,HashMap<Course, Mark> marks) {
        super();
        this.yearOfStudy = yearOfStudy;
        this.courses = courses;
        this.degree = degree;
        this.creditLimit = creditLimit;
        this.totalCredits = totalCredits;
        this.marks = marks;
    }
    
    private Integer getYearOfStudy() {
        return this.yearOfStudy;
    }

    /**
     * @generated
     */
    private void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
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
    private void setCourses(ArrayList <Course> courses,Faculty faculty) {
        this.courses = courses;
    }

    /**
     * @generated
     */
    private Faculty getFaculty() {
        return this.faculty;
    }

    /**
     * @generated
     */
    private void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * @generated
     */
    private Degree getDegree() {
        return this.degree;
    }

    /**
     * @generated
     */
    private void setDegree(Degree degree) {
        this.degree = degree;
    }

    /**
     * @generated
     */
    private Integer getCreditLimit() {
        return this.creditLimit;
    }

    /**
     * @generated
     */
    private void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * @generated
     */
    private Integer getTotalCredits() {
        return this.totalCredits;
    }

    /**
     * @generated
     */
    private void setTotalCredits(Integer totalCredits) {
        this.totalCredits = totalCredits;
    }

    /**
     * @generated
     */
    private HashMap <Course, Mark> getMarks() {
        return this.marks;
    }

    /**
     * @generated
     */
    private void setMarks(HashMap <Course, Mark> marks) {
        this.marks = marks;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return super.equals(s) && s.yearOfStudy == yearOfStudy && s.faculty.equals(faculty) && s.degree.equals(degree);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), yearOfStudy,faculty,degree);
    }
    
    public void increaseYearOfStudy() {
        this.currentYearOfStudy++;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nYearOfStudy [" + yearOfStudy + "]" + "\nFaculty [" + faculty + "]" + "\nDegree [" + degree + "]";
    }
//
//    //                          Operations
//
//    /**
//     * @generated
//     */
//    public getYear() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public setYear() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public getFaculty() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public setFaculty() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public viewTranscript() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public registerCourses() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public withdrawCourses() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public rateTeachers() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public viewTeachersInfo() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public getTranscript() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public viewSchedule() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public viewMarks() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public sendRequestToLibrary() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public viewCoursesFiles() {
//        //TODO
//    }
//    /**
//     * @generated
//     */
//    public increaseYearOfStudy() {
//        //TODO
//    }

}
