import java.util.Objects;

/**
* @generated
*/
public class CourseFiles implements Cloneable{
    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private String content;
    private Course course;

    public CourseFiles() {}

    public CourseFiles(String name, String content) {
        this.name = name;
        this.content = content;
    }

    /**
     * @generated
     */
    
    public String getName() {
		    return name;
    }

    /**
    * @generated
    */
    private void setName(String name) {
        this.name = name;
    }
    
    /**
    * @generated
    */
    public String getContent() {
        return this.content;
    }
    
    /**
    * @generated
    */
    public void setContent(String content) {
        this.content = content;
    }

    /**
    * @generated
    */
    public Course getCourse() {
        return this.course;
    }
    
    /**
    * @generated
    */
    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseFiles that = (CourseFiles) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(content, that.content)) return false;
        return Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
    	return course.getTitle() + " file { name: " + name + ", content: " + content +"}"; 
    }

    public Object clone() throws CloneNotSupportedException{
    	return super.clone();
    }
}
