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

	public ArrayList<String> getCourses(){
		ArrayList<String> course = new ArrayList<String>();
		for (Course c: courses) {
			course.add(c.getTitle());
		}
		return course;
	}

	public void setCourses(Course course) {
		courses.add(course);
	}

	public ArrayList<Student>viewStudentsInfo(Course course){
		return course.getStudents();
	}

	public void putMark(Course course, TypeOfMark typeOfMark, double points, Student student, Database database) {
		course.putMark(student, points, typeOfMark, database);
		Mark m = course.getMarkOfStudent(student);
		student.setCourseMark(course, m);
	}

	public void addFiles(Course course, CourseFiles courseFiles) {
		course.setCourseFiles(courseFiles);
	}

	public void deleteFiles(Course course, CourseFiles courseFiles) {
		course.deleteCourseFiles(courseFiles);
	}

	public HashSet<String>viewCourseFiles(Course course){
		HashSet<String> coursef = new HashSet<String>();
		for (CourseFiles cf : course.getCourseFiles()) {
			coursef.add(cf.getName());
		}
		return coursef;
	}
	public int hashCode() {
        return Objects.hash(super.hashCode(),faculty,academicDegree);
    }
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        Teacher t = (Teacher) o;
        return t.faculty.equals(faculty) || t.academicDegree.equals(academicDegree);
    }
    public String toString() {
    	return super.toString() + "," + academicDegree + " of " + faculty;
    }
    public ArrayList<News>seeNews() {
    	return news;
    }

	public HashMap<String, Mark> getMarksOfStudent(Student student){
		HashMap<String, Mark> marksOfStudent = new HashMap<String, Mark>();
		for (Course c: courses) {
			marksOfStudent.put(c.getTitle(), c.getMarkOfStudent(student));
		}
		return marksOfStudent;
	}
	public HashMap<Student, Mark> getMarksOfStudents(Course course){
		HashMap<Student, Mark> markOfStudents = new HashMap<Student, Mark>();
		for (Student s: course.getStudents()) {
			markOfStudents.put(s, course.getMarkOfStudent(s));
		}
		return markOfStudents;
	}
}
