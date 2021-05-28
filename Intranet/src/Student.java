import java.util.*;


/**
 * @generated
 */
/**
 * Represents Students information and account
 * @extends User
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
    private HashMap<Course, Mark> marks = new HashMap<>();
    private ArrayList<Course> courses = new ArrayList<>();
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
        return courses;
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
     * Get student's total number of credits.
     * @return Returns total number of credits.
     */
    public Integer getTotalCredits() {
        return this.totalCredits;
    }

    /**
     * Set new value for total credits.
     * @param totalCredits - new value for total credits
     */
    public void setTotalCredits(Integer totalCredits) {
        this.totalCredits = totalCredits;
    }
    /**
     * Equals metod to compare.
     * @param o - Object object which we compare.
     * @return Returns true if objects are equal and false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return super.equals(s) && s.yearOfStudy.equals(yearOfStudy) &&
                s.faculty.equals(faculty) && s.degree.equals(degree);
    }
    /**
     * Hash code method.
     * @return Returns hash of object;
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), yearOfStudy,faculty,degree);
    }
    /**
     * Increase year of study of student.
     */
    public void increaseYearOfStudy() {
        this.yearOfStudy++;
    }
    
    /**
     * Withdraw particular course.
     * @param course - Course object which need to be removed from courses.
     */
    public void withdrawCourses(Course course) {
    	courses.remove(course);
    }

    public void sendRequestToLibrary(Order order, Book book) {
    	order.setBook(book);
    	Librarian.addOrder(order);	
    }
    /**
     * Withdraw particular course.
     * @param course - Course object, we can see its course files.
     * @return Returns HashSet of course files.
     */
    public HashSet<String> viewCourseFiles(Course course){
        HashSet<String> courseFiles = new HashSet<>();
        for (CourseFiles courseFile : course.getCourseFiles()) {
            courseFiles.add(courseFile.getName() + " " + courseFile.getContent());
        }
        return courseFiles;
    }
    /**
     * Register particular course.
     * @param course - Course object which need to be registered.
     * @return Returns true if course was successfully registered and false if wasn't.
     */
    public boolean registerForCourse(Course course) {
        if (!isAlreadyRegistered(course) && getCoursesForRegistration().contains(course)) {
            course.setStudents(this);
            this.setCourses(course);
            return true;
        }
        return false;
    }
    /**
     * Rate particular teacher.
     * @param teacher - Teacher object which need to be rated.
     * @param rate - points for rating
     */
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
    /**
     * Set mark for student for particular type(first attestation,second or final).
     * @param course - Course object, we add mark to this course.
     * @param mark - Mark object of student for particular course.
     */
    public void setCourseMark(Course course, Mark mark) {
    	marks.put(course, mark);
    }
    /**
     * View mark for particular course.
     * @param course - Course object, we see mark for this course.
     * @return Returns Marks of student.
     */
    public Mark viewMark(Course course) {
    	return marks.get(course);
    }
    /**
     * View transcript.
     */
    public void viewTranscript() {
        double totalGPA = 0;
    	for (Course c : marks.keySet()) {
    		System.out.print(c.getTitle() + " | " + marks.get(c).getFirstAttestation() + " | "
                    + marks.get(c).getSecondAttestation() +" | " + marks.get(c).getFinal() + " | "
                    + marks.get(c).getTotal() + " | " + marks.get(c).getLiteralMark() +
                    " | " + marks.get(c).getDigitMark() + " | " + "\n");
    	}
        for (Course c : marks.keySet()) {
            totalGPA += (marks.get(c).getDigitMark() * c.getCredits()) / (c.getCredits() * marks.size());
        }
    	System.out.println("Total GPA: " + totalGPA);
    }
    /**
     * Checks if student has a particular course.
     * @param course - Course object which need to be checked.
     * @return Returns true if student has this course and false if hasn't.
     */
    public boolean isAlreadyRegistered(Course course) {
        return courses.contains(course);
    }
    /**
     * Get courses for registartion.
     * @return Returns ArrayList of courses, available for registration.
     */
    public ArrayList<Course> getCoursesForRegistration() {
        ArrayList<Course> allowedCourses = new ArrayList<>();
        for (Course course: Database.courses)
            if (course.getFaculty().equals(this.getFaculty()))
                allowedCourses.add(course);
        return allowedCourses;
    }

    /**
     * Set course to courses.
     * @param course - Course object which need to be added to courses.
     */
    public void setCourses(Course course) {
        courses.add(course);
    }


//    //                          Operations
//
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
//    /**
//     * @generated
//     */


//    public sendRequestToLibrary() {
//        //TODO
//    }

}
