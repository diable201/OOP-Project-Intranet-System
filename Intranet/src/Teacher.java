import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
* @generated
*/
/**
 * Represents Teacher’s information and account
 * @extends Employee class
 */
public class Teacher extends Employee {
    
    /**
    * @generated
    */
	/**
	 * variable for academicDegree
	 */
	private AcademicDegree academicDegree;
	/**
	 * variable for all courses
	 */
	private ArrayList<Course> courses = new ArrayList<>();
	/**
	 * variable for all news
	 */
	private ArrayList<News> news = new ArrayList<>();
	/**
	 * variable for faculty
	 */
	private Faculty faculty;
	/**
	 * variable for number of votes of Teacher
	 */
	private int numberOfVotes;
	/**
	 * variable for representing rate of teacher
	 */
	private double rate;

	public Teacher() {
		super();
	}

	public Teacher(String id, String name, String surname,
				   EmployeeTypes department, AcademicDegree academicDegree) {
		super(id, name, surname, department);
		this.academicDegree = academicDegree;
	}
	/**
	 * get Academic degree of Teacher
	 * @return Academic degree of Teacher
	 */
	public AcademicDegree getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(AcademicDegree academicDegree) {
		this.academicDegree = academicDegree;
	}
	/**
	 * get Academic faculty of Teacher
	 * @return Academic faculty of Teacher
	 */
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	/**
	 * get courses of Teacher
	 * @return Array list of courses
	 */
	public ArrayList<Course> getCourses(){
		return courses;
	}
	/**
	 * get courses of Teacher
	 * @param Courses
	 */
	public void setCourses(Course course) {
		courses.add(course);
	}
	/**
	 * get every student's for course
	 * @param current course
	 * @return Array list of courses
	 */
	public ArrayList<Student>viewStudentsInfo(Course course){
		return course.getStudents();
	}

	public void putMark(Course course, TypeOfMark typeOfMark, double points, Student student) {
		course.putMark(student, points, typeOfMark);
		Mark m = course.getMarkOfStudent(student);
		student.setCourseMark(course, m);
	}

	public void addFiles(Course course, CourseFiles courseFiles) {
		course.setCourseFiles(courseFiles);
	}
	/**
	 * checking process of deleting files
	 * @param Course files and Course
	 * @return boolean expression if file deleted
	 */
	public boolean deleteFiles(Course course, CourseFiles courseFiles) {
		return course.deleteCourseFiles(courseFiles);
	}

	/**
	 * view Course files
	 * @param current course
	 * @return Hash set of course files
	 */
	public HashSet<String>viewCourseFiles(Course course){
		HashSet<String> courseFiles = new HashSet<String>();
		for (CourseFiles courseFile : course.getCourseFiles()) {
			courseFiles.add(courseFile.getName() + " " + courseFile.getContent());
		}
		return courseFiles;
	}
	/**
	 * get number of votes
	 * 
	 * @return number of votes Teacher
	 */
	public int getNumberOfVotes() {
		return this.numberOfVotes;
	}
	/**
	 * set number of votes
	 * 
	 * @param number of votes Teacher
	 */
	public void setNumberOfVotes(int numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
	/**
	 * get rate of teacher
	 * 
	 * @return rate of Teacher
	 */
	public double getRate() {
		return this.rate;
	}
	/**
	 * set rate of teacher
	 * 
	 * @param rate of Teacher from user
	 */
	public void setRate(double rate) {
		this.numberOfVotes++;
		this.rate += rate;
		this.rate /= this.numberOfVotes;
	}
	/**
	 * getting hash code
	 * 
	 * @return hash code of object
	 */
	public int hashCode() {
        return Objects.hash(super.hashCode(),faculty,academicDegree);
    }
	/**
	 * equals method
	 * @param object Teacher
	 * @return boolean expression if objects are equal
	 */
    public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Teacher)) return false;
		Teacher t = (Teacher) o;
		return super.equals(t) &&
				t.faculty.equals(faculty) && t.academicDegree.equals(academicDegree);
	}

    /**
	 * to string method
	 * 
	 * @return all information about Teacher
	 */
    @Override
    public String toString() {
		return "Teacher {" +
				super.toString() +
				"Degree" + academicDegree +
				'}';
    }
    /**
	 * seeing news
	 * 
	 * @return all news
	 */
    public ArrayList<News>seeNews() {
    	return news;
    }
    /**
	 * get marks for one student
	 * @param current student
	 * @return hash map of course and mark
	 */
	public HashMap<String, Mark> getMarksOfStudent(Student student){
		HashMap<String, Mark> marksOfStudent = new HashMap<>();
		for (Course c: courses) {
			marksOfStudent.put(c.getTitle(), c.getMarkOfStudent(student));
		}
		return marksOfStudent;
	}
	/**
	 * get marks of student for course
	 * @param current course
	 * @return hash map of student and mark
	 */
	public HashMap<Student, Mark> getMarksOfStudents(Course course){
		HashMap<Student, Mark> markOfStudents = new HashMap<>();
		for (Student s: course.getStudents()) {
			markOfStudents.put(s, course.getMarkOfStudent(s));
		}
		return markOfStudents;
	}
	/**
	 * get all teaching courses
	 * e
	 * @return array list of all courses
	 */
	public ArrayList<Course> getTeachingCourses() {
		ArrayList<Course> courses = new ArrayList<>();
		for (Course course: Database.courses)
			if (course.getTeacher().equals(this))
				courses.add(course);
		return courses;
	}


	@Override
	public void sentMessage() {

	}
	/**
	 * get all messages
	 * e
	 * @return all messages
	 */
	@Override
	public String getMessage() {
		StringBuilder ans = new StringBuilder();
		int msgCount = 0;
		for (Message message : Database.messages) {
			if (message.getReceiver().equals(this.getId())) {
				msgCount ++;
				ans.append(msgCount).append(") Message for Teacher from: ").append(message.getSender()).append("\n    " +
						"Text: ").append(message.getBody()).append("\n\n");
			}
		}
		return ans.toString();
	}

}
