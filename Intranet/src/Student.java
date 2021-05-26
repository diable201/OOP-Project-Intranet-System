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
    private HashMap<Course, Mark> marks = new HashMap<Course, Mark>();
    private ArrayList<Course> courses = new ArrayList<Course>();
    /**
     * @generated
     */

    public Student() {
        super();
    }
    
    public Student(String id, String name, String surname, Integer yearOfStudy, Faculty faculty, Degree degree) {
        super(id, name, surname);
        this.yearOfStudy = yearOfStudy;
        this.faculty = faculty;
        this.degree = degree;
    }
    public Student(String id, String name, String surname,
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
    
    public Integer getYearOfStudy() {
        return this.yearOfStudy;
    }

    /**
     * @generated
     */
    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    /**
     * @generated
     */
    public ArrayList <Course> getCourses() {
        return this.courses;
    }

    /**
     * @generated
     */

    public void setCourses(ArrayList <Course> courses) {
        this.courses = courses;
    }

    /**
     * @generated
     */
    public Faculty getFaculty() {
        return this.faculty;
    }

    /**
     * @generated
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * @generated
     */
    public Degree getDegree() {
        return this.degree;
    }

    /**
     * @generated
     */
    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    /**
     * @generated
     */
    public Integer getCreditLimit() {
        return this.creditLimit;
    }

    /**
     * @generated
     */
    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * @generated
     */
    public Integer getTotalCredits() {
        return this.totalCredits;
    }

    /**
     * @generated
     */
    public void setTotalCredits(Integer totalCredits) {
        this.totalCredits = totalCredits;
    }

    /**
     * @generated
     */
    public HashMap <Course, Mark> getMarks() {
        return this.marks;
    }

    /**
     * @generated
     */
    public void setMarks(HashMap <Course, Mark> marks) {
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
        this.yearOfStudy++;
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

    public boolean registerForCourse(Course course) {
        if (!isHavingCourse(course) && getCoursesForRegistration().contains(course)) {
            this.setCourses(course);
            return true;
        }
        return false;
    }
    
    public void rateTeachers(Teacher teacher, double rate) {
    	teacher.setRate(rate);	
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nYearOfStudy [" + yearOfStudy + "]" + "\nFaculty [" + faculty + "]" + "\nDegree [" + degree + "]";
    }

    @Override
    public int compareTo(User o) {
    	Student s = (Student) o;
    	return getUsername().compareTo(s.getUsername());
    }
//   
    public void setCourseMark(Course course, Mark mark) {
    	marks.put(course, mark);
    }
    public Mark viewMark2(Course course) {
    	return marks.get(course);
    }
    public void viewTranscript2() {
    	
    	for (Course c : marks.keySet()) {
    		System.out.print(c.getTitle() + " | " + marks.get(c).getFirstAttestation() + " | " + marks.get(c).getSecondAttestation() +" | " +
    	marks.get(c).getFinal() + " | " + marks.get(c).getTotal() + " | " + marks.get(c).getLiteralMark()+ "\n");
    	}    	
    }

    public boolean isHavingCourse(Course course) {
        return courses.contains(course);
    }

    public ArrayList<Course> getCoursesForRegistration() {
        ArrayList<Course> allowedCourses = new ArrayList<>();
        for (Course course: Database.courses)
            if (course.getFaculty().equals(this.getFaculty()))
                allowedCourses.add(course);
        return allowedCourses;
    }


    public void setCourses(Course course) {
        courses.add(course);
    }
    
//    public HashSet<CourseFiles>viewCourseFiles2(Course course) {
//    	return course.getCourseFiles();
//    }
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
