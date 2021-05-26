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
	public Course() {
	}
	
	public Course(String code, String title, int credits) {
		this.code = code;
		this.title = title;
		this.credits = credits;
	}
	
	private String code;
	/**
	    * @generated
	    */
	private String title;
	/**
	    * @generated
	    */
	private int credits;
	/**
	    * @generated
	    */
	private int limitOfStudents;
	/**
	    * @generated
	    */
	private HashSet<CourseFiles>courseFiles = new HashSet<CourseFiles>();
	
	private HashSet<Course>prerequisites = new HashSet<Course>();
	private ArrayList<Student>students = new ArrayList<Student>();
	private HashMap<Student, Mark>marks = new HashMap<Student, Mark>();
	private ArrayList<Lesson>lessons = new ArrayList<Lesson>();
	/**
    * @generated
    */
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getLimitOfStudents() {
		return limitOfStudents;
	}
	public void setLimitOfStudents(int limitOfStudents) {
		this.limitOfStudents = limitOfStudents;
	}
	public void setCourseFiles(CourseFiles courseF) {
		courseFiles.add(courseF);
	}
	public void deleteCourseFiles(CourseFiles courseF) {
		courseFiles.remove(courseF);
	}
	public HashSet<CourseFiles> getCourseFiles(){
		return courseFiles;
	}
	public void setPrerequisites(Course c) {
		prerequisites.add(c);
	}
	public HashSet<Course> getPrerequisites(){
		return prerequisites;
	}
	public void setStudents(Student s) {
		students.add(s);
		Mark m = new Mark();
		m.setStudent(s);
		marks.put(s, m);
	}
	public ArrayList<Student> getStudents(){
		return students;
	}
	public void setLessons(Lesson l) {
		lessons.add(l);
	}
	public ArrayList<Lesson> getLessons(){
		return lessons;
	}
	public void putMark(Student student, double points, TypeOfMark typeOfMark, Database database) {
		try {
			Mark mark = marks.get(student);
			mark.putMark(typeOfMark, points);
//			database.setStudentMarks(marks);
			System.out.println("Successful operation");
		} catch(Exception e) {
			System.out.println("Unsuccessful operation: This student is not registered in this course.");
		}
		
	}
	
	public Mark getMarkOfStudent(Student student){
		return marks.get(student);
	}
    
	public HashMap<Student, Mark> getMarks() {
		return marks;
	}

	public void setMarks(HashMap<Student, Mark> marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Course{" +
				"code='" + code + '\'' +
				", title='" + title + '\'' +
				", credits=" + credits +
				'}';
	}
}
