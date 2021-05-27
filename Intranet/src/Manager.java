import java.util.ArrayList;
import java.util.Collections;


/**
 * Manager is employee who manages all users.
 */
public class Manager extends Employee {

    /**
     * ArrayList of all courses.
     */
    private ArrayList<Course> courses;

    /**
     * ArrayList of all teachers.
     */
    private ArrayList <Teacher> teachers;

    /**
     * ArrayList of all students.
     */
    private ArrayList <Student> students;
    
    /**
     * ArrayList of all news.
     */
    private ArrayList <News> news;
    
    public Manager(String id, String name, String surname, EmployeeTypes department) {
        super(id, name, surname, department);
    }

    public Manager() {

    }


    /**
     * Returns all courses.
     * @return Returns ArrayList of all courses.
     */
    public ArrayList <Course> getCourses() {
        return this.courses;
    }

    /**
     * Set all courses.
     * @param courses - ArrayList of courses which need to be added
     */
    public void setCourses(ArrayList <Course> courses) {
        this.courses = courses;
    }

    /**
     * Returns all teachers.
     * @return Returns ArrayList of all teachers.
     */
    public ArrayList <Teacher> getTeachers() {
        return this.teachers;
    }

    /**
     * Set all teachers.
     * @param teachers - ArrayList of teachers which need to be added
     */
    public void setTeachers(ArrayList <Teacher> teachers) {
        this.teachers = teachers;
    }

    /**
     * Returns all students.
     * @return Returns ArrayList of all students.
     */
    public ArrayList <Student> getStudents() {
        return this.students;
    }

    /**
     * Set all students.
     * @param students - ArrayList of students which need to be added
     */
    public void setStudents(ArrayList <Student> students) {
        this.students = students;
    }

    /**
     * Returns all news.
     * @return Returns ArrayList of all news.
     */
    public ArrayList <News> getNews() {
        return this.news;
    }
    /**
     * Set all news.
     * @param news - ArrayList of news which need to be added
     */
    public void setNews(ArrayList<News> news) {
        this.news = news;
    }


    //                          Operations


//    public createStatisticalReport() {
//        //TODO
//    }
    /**
     * Add course to courses.
     * @param course - Course object which need to be added
     * @return Return yes if course was successfully added and no if wasn't.
     */
    public boolean addCourse(Course course) {
        if (course != null && course.getTeacher() != null) {
            for (Course courses: Database.courses)
                if (courses.getTitle().equals(course.getTitle()) && courses.getTeacher().equals(course.getTeacher()))
                    return false;
            Database.courses.add(course);

//            Database.logFiles.add(new LogFile(LogType.COURSE_CREATED));
        }
        return true;
    }
    /**
     * Delete course from courses.
     * @param course - Course object which need to be deleted
     */
    public void deleteCourse(Course course) {
//        courses.remove(course);
        Database.courses.remove(course);
    }
    /**
     * Change limit of students of particular course.
     * @param course - Course object which need to be changed
     * @param number - new students limit for course
     */
    public void changeLimitOfStudents(Course course, int number) {
        course.setLimitOfStudents(number);
    }
    /**
     * Change number of credits of particular course.
     * @param course - Course object which need to be changed
     * @param number - new number of credits for course
     */
    public void changeNumberOfCredits(Course course, int number) {
        course.setCredits(number);
    }
    /**
     * Change registration status to open.
     */
    public void openRegistration() {
        Database.registrationIsOpen = true;
    }
    /**
     * Change registration status to closed.
     */
    public void closeRegistration() {
        Database.registrationIsOpen = false;
    }
    /**
     *Get registration status.
     */
    public boolean getRegistration() {
    	return Database.registrationIsOpen;
    }
    
    public void extendRegistration() {
        if(!Database.registrationIsOpen) {
            Database.registrationIsOpen = true;
        }
    }
    /**
     * Add news.
     * @param n - object of News class which need to be added.
     */
    public void addNews(News n) {
        news.add(n);
    }
    /**
     *Update description of particular news.
     * @param n - object of News class which need to be updated.
     * @param description - new description of news
     */
    public void updateNews(News n, String description) {
        n.setDescription(description);
    }
    /**
     * Delete news.
     * @param n - object of News class which need to be deleted.
     */
    public void deleteNews(News n) {
        news.remove(n);
    }
    /**
     * View teachers sorted by name.
     * @return Return ArrayList of teachers sorted in alphabetic order.
     */
    public ArrayList <Teacher> viewTeachersInAlphabeticOrder() {
        Collections.sort(teachers, new SortTeacherByName());
        return teachers;
    }
    /**
     * View courses of specific teacher.
     * @param teacher - Teacher Object,we get his courses.
     * @return Return ArrayList of courses of particular teacher.
     */
    public ArrayList<Course> viewTeachersCourse(Teacher teacher) {
        return teacher.getCourses();
    }
    /**
     * View transcript of particular student.
     * @param student - Student object,we see his transctipt.
     */
    public void viewStudentsTranscript(Student student) {
        student.viewTranscript();
    }
    /**
     * View students sorted by name.
     * @return Return ArrayList of students sorted in alphabetic order.
     */
    public ArrayList <Student> viewStudentsInAlphabeticOrder() {
        Collections.sort(students, new SortStudentByName());
        return students;
    }
    
    public ArrayList<Student>viewStudentsByGPA(Course course) {
        Collections.sort(students, new SortStudentByGpa(course));
        return students;
    }
    
    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                '}';
    }

    public void sentMessage() {

    }

    public String getMessage() {
        StringBuilder ans = new StringBuilder();
        int msgCount = 0;
        for (Message message : Database.messages) {
            if(message.getReceiver().equals(this.getUsername())) {
                msgCount++;
                ans.append(msgCount).append(") Message for Admin from: ").append(message.getSender()).append("\n" +
                        "Text: ").append(message.getBody()).append("\n\n");
            }
        }
        return ans.toString();
    }
}
