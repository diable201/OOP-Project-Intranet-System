import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
* @generated
*/
public class Teacher extends Employee {
    
    /**
    * @generated
    */
	private AcademicDegree academicDegree;
	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<News> news = new ArrayList<News>();
	private Faculty faculty;

	public Teacher() {
		super();
	}


	public Teacher(String id, String name, String surname,
				   EmployeeTypes department, AcademicDegree academicDegree) {
		super(id, name, surname, department);
		this.academicDegree = academicDegree;
	}

	public AcademicDegree getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(AcademicDegree academicDegree) {
		this.academicDegree = academicDegree;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
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
		course.putMark(student, points, typeOfMark);
	}

	public void addFiles(Course course, CourseFiles courseFiles) {
		course.setCourseFiles(courseFiles);
	}

	public void deleteFiles(Course course, CourseFiles courseFiles) {
		course.deleteCourseFiles(courseFiles);
	}

	public HashSet<CourseFiles>viewCourseFiles(Course course) {
		return course.getCourseFiles();
	}

	public int hashCode() {
        return Objects.hash(super.hashCode(),faculty,academicDegree);
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher t = (Teacher) o;
        return super.equals(t) && t.faculty.equals(faculty) && t.academicDegree.equals(academicDegree);
    }

    public String toString() {
    	return super.toString() + "," + academicDegree + " of " + faculty;
    }

    public ArrayList<News>seeNews() {
    	return news;
    }

	public HashMap<Course, Mark> getMarksOfStudent(Student student){
		HashMap<Course, Mark> marksOfStudent = new HashMap<Course, Mark>();
		for (Course c: courses) {
			marksOfStudent.put(c, c.getMarkOfStudent(student));
		}
		return marksOfStudent;
	}
//  public HashMap<Student, Mark> getMarksOfStudents(Course course){
//		HashMap<Student, Mark> markOfStudents = new HashMap<Student, Mark>();
//		for (Student s: course.getStudents()) {
//			markOfStudents.put(s, s.getCourseMarks(course));
//		}
//		return markOfStudents;
//	}
}
