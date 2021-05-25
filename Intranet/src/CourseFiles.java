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
    private String getContent() {
        return this.content;
    }
    
    /**
    * @generated
    */
    private void setContent(String content) {
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

    //                          Operations   
    public String toString() {
    	return course.getTitle() + " file { name: " + name + ", content: " + content +"}"; 
    }
    public Object clone() throws CloneNotSupportedException{
    	return super.clone();
    }
}
