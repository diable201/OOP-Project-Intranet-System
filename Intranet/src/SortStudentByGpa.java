import java.util.Comparator;

public class SortStudentByGpa implements Comparator<Student>{
	private Course course;
	public SortStudentByGpa(Course course) {
		this.course = course;
	}
	public int compare(Student s1, Student s2) {      
		Mark m1 = s1.viewMark2(course);
		Mark m2 = s2.viewMark2(course);
        return m1.returnGpa().compareTo(m2.returnGpa());
    }

}
