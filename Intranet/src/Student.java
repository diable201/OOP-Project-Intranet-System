import java.util.*;


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

    public HashSet<String> viewCourseFiles(Course course){
        HashSet<String> courseFiles = new HashSet<>();
        for (CourseFiles courseFile : course.getCourseFiles()) {
            courseFiles.add(courseFile.getName() + " " + courseFile.getContent());
        }
        return courseFiles;
    }

    public boolean registerForCourse(Course course) {
        if (!isHavingCourse(course) && getCoursesForRegistration().contains(course)) {
            course.setStudents(this);
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
    public void viewTranscript() {
        double totalGPA = 0;
    	for (Course c : marks.keySet()) {
    		System.out.print(c.getTitle() + " | " + marks.get(c).getFirstAttestation() + " | "
                    + marks.get(c).getSecondAttestation() +" | " + marks.get(c).getFinal() + " | "
                    + marks.get(c).getTotal() + " | " + marks.get(c).getLiteralMark() +
                    " | " + marks.get(c).getDigitMark() + " | " + "\n" + marks.size());
    	}
        for (Course c : marks.keySet()) {
            totalGPA += (marks.get(c).getDigitMark() * c.getCredits()) / (c.getCredits() * marks.size());
        }
    	System.out.println("Total GPA: " + totalGPA);
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
//    public viewMarks() {
//        //TODO
//    }

//    public sendRequestToLibrary() {
//        //TODO
//    }

}
