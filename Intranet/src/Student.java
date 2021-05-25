import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    public Student(Integer id, String name, String surname,
                   Integer yearOfStudy,ArrayList<Course> courses,Degree degree,
                   Integer creditLimit,Integer totalCredits,HashMap<Course, Mark> marks) {
        super(id, name, surname);
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

    private void setCourses(ArrayList <Course> courses) {
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
        return super.equals(s) && s.yearOfStudy.equals(yearOfStudy) &&
                s.faculty.equals(faculty) && s.degree.equals(degree);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), yearOfStudy,faculty,degree);
    }
    
    public void increaseYearOfStudy() {
        this.currentYearOfStudy++;
    }
    
    public void viewTranscript() {
    	String result = "";
    	for (Map.Entry <Course,Mark> marks: marks.entrySet()) {
    		result += "Course Name: " + marks.getKey().getTitle() + "Mark: " + marks.getValue().getTotal() +"\n";	
    	}
    	System.out.print(result);
    }
    public void registerCourses(Course course) {
    	courses.add(course);
    }
    
    public void withdrawCourses(Course course) {
    	courses.remove(course);
    }
    
    public double viewMark(Course course) {
    	double points;
    	points = marks.get(course).getTotal();
    	return points;
    }
    
    public void sendRequestToLibrary(Order order, Book book) {
    	order.setBook(book);
    	Librarian.addOrder(order);	
    }
    
    public void viewCourseFiles(Course course) {
    	if(courses.contains(course)) {
    		for(CourseFiles coursefiles : course.getCourseFiles()) {
    			System.out.println(coursefiles.toString());
    		}
    	}
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nYearOfStudy [" + yearOfStudy + "]" + "\nFaculty [" + faculty + "]" + "\nDegree [" + degree + "]";
    }

    @Override
    public int compareTo(User o) {
        return 0;
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
