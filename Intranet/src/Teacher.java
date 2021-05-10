import java.util.ArrayList;
import java.util.HashSet;

/**
* @generated
*/
public class Teacher extends Employee{
    
    /**
    * @generated
    */
    
    public Teacher() {
		super();
	}
	private Degree academicDegree;
	private ArrayList<Course>courses = new ArrayList<Course>();
	public Degree getAcademicDegree() {
		return academicDegree;
	}
	public void setAcademicDegree(Degree academicDegree) {
		this.academicDegree = academicDegree;
	}
	public ArrayList<Course> getCourses(){
		return courses;
	}
	public void setCourses(Course course) {
		courses.add(course);
	}
	public ArrayList<Student>viewStudentsInfo(Course course){
		return course.getStudents();
	}
	public void putMark(Course course, TypeOfMark typeOfMark, double points, Student student) {
		//сюда короче вызываем метод типа course.setMarkToStudent - надо такой метод создать еще в классе Курс
	}
	public void addFiles(Course course, CourseFiles courseFiles) {
		course.setCourseFiles(courseFiles);
	}
	public void deleteFiles(Course course, CourseFiles courseFiles) {
		course.deleteCourseFiles(courseFiles);
	}
	public HashSet<CourseFiles>viewCourseFiles(Course course){
		return course.getCourseFiles();
	}
    
    
}
