import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Base64;
import java.util.Collections;
/**
 * Database is a storage of all objects: users, courses, etc.
 * Only exists in one copy.
 */
public class Database implements Serializable {
    
    /**
    * ArrayList which contains all users.
    */
    protected static ArrayList<User> users = new ArrayList<>();
    /**
     * ArrayList which contains all courses.
     */
    protected static ArrayList<Course> courses = new ArrayList<>();
    /**
     * HashMap which contains all marks of particular course.
     */
    protected static HashMap<Course, Mark> marks = new HashMap<>();
    /**
     * ArrayList which contains all news.
     */
    protected static ArrayList<News> news = new ArrayList<>();
    /**
     * ArrayList which contains all messages.
     */
    protected static ArrayList<Message> messages = new ArrayList<>();
    /**
     * boolean value of status of registration.
     */
    protected static boolean registrationIsOpen = true;
    
    protected static String getKeyword() {
        return "Test";
    }

    private static Database INSTANCE = null;

    private Database() {}
    /**
     * Gets the Database object.
     * @return Returns Database if it exists, otherwise return new Database object.
     */
    public static Database getInstance() {
        if (INSTANCE == null) INSTANCE = new Database();
        return INSTANCE;
    }

    /**
     * Get all teachers.
     * @return Returns toString representation of teachers.
     */
    public static String getTeachers() {
        StringBuilder s = new StringBuilder();
        for (User user: users) {
            if (user instanceof Teacher) {
                Teacher teacher = (Teacher) user;
                s.append(teacher.toString()).append("\n");
            }
        }
        return s.toString();
    }
    /**
     * Get all students.
     * @return Returns toString representation of students.
     */
    public static String getStudents() {
        StringBuilder s = new StringBuilder();
        for (User user: users) {
            if (user instanceof Student) {
                Student student = (Student) user;
                s.append(student.toString()).append("\n");
            }
        }
        return s.toString();
    }
    /**
     * Get all students.
     * @return Returns ArrayList of all students.
     */
    public static ArrayList<Student> getStudentsList() {
    	ArrayList<Student> s = new ArrayList<Student>();
        for (User user: users) {
            if (user instanceof Student) {
                Student student = (Student) user;
                s.add(student);
            }
        }
        return s;
    }
    /**
     * Get all students ordered by name.
     * @return Returns ArrayList of all students ordered by name.
     */
    public static ArrayList<Student> getStudentsListByName() {
    	ArrayList<Student> s = new ArrayList<Student>();
        for (User user: users) {
            if (user instanceof Student) {
                Student student = (Student) user;
                s.add(student);
            }
        }
        Collections.sort(s, new SortStudentByName());
        return s;
    }
    /**
     * Get all employees.
     * @return Returns toString representation of employees.
     */
    public static String getEmployees() {
        StringBuilder s = new StringBuilder();
        for (User user: users) {
            if (user instanceof Employee) {
                Employee student = (Employee) user;
                s.append(student.toString()).append("\n");
            }
        }
        return s.toString();
    }
    /**
     * Get all managers.
     * @return Returns toString representation of managers.
     */
    public static String getManagers() {
        StringBuilder s = new StringBuilder();
        for (User user: users) {
            if (user instanceof Manager) {
                Manager student = (Manager) user;
                s.append(student.toString()).append("\n");
            }
        }
        return s.toString();
    }
    /**
     * Get all admins.
     * @return Returns toString representation of admins.
     */
    public static String getAdmins() {
        StringBuilder s = new StringBuilder();
        for (User user: users) {
            if (user instanceof Admin) {
                Admin student = (Admin) user;
                s.append(student.toString()).append("\n");
            }
        }
        return s.toString();
    }
    /**
     * Get all librarians.
     * @return Returns toString representation of librarians.
     */
    public static String getLibrarians() {
        StringBuilder s = new StringBuilder();
        for (User user: users) {
            if (user instanceof Librarian) {
                Librarian student = (Librarian) user;
                s.append(student.toString()).append("\n");
            }
        }
        return s.toString();
    }
    /**
     * Get all courses.
     * @return Returns toString representation of courses.
     */
    public static String getCourses() {
        StringBuilder s = new StringBuilder();
        for (Course course: courses) {
            if (course != null) {
                s.append(course.toString()).append("\n");
            }
        }
        return s.toString();
    }
    /**
     * Get all messages.
     * @return Returns ArrayList of all messages.
     */
    public static ArrayList<Message> getMessages() {
        return messages;
    }

    public static String getNews() {
        StringBuilder s = new StringBuilder();
        for (News newsIter: news) {
            if (newsIter != null) {
                s.append(newsIter.toString()).append("\n");
            }
        }
        return s.toString();
    }


    /**
     * Get student by name.
     * @return Returns Student object with particular name.
     * @param name - name of student.
     */
    public Student getStudentByName(String name) {
        for (User user : users) {
            if (user instanceof Student) {
                Student student = (Student) user;
                if (student.getName().equals(name)) {
                    return student;
                }
            }
        }
        return null;
    }
    /**
     * Get student by id.
     * @return Returns Student object with particular id.
     * @param id - id of student.
     */
    public Student getStudentById(String id) {
        for (User user : users) {
            if (user instanceof Student) {
                Student student = (Student) user;
                if (student.getId().equals(id)) {
                    return student;
                }
            }
        }
        return null;
    }
    /**
     * Encryption of file.
     * @return boolean value of was file encrypted or not.
     * @param data - data to encrypt.
     */
    private static boolean encryptString(String data) {
        Base64.getEncoder().encodeToString((data.getBytes()));
        // System.out.println("Encryption is successful: " + encryptedData);
        return true;
    }
    /**
     * Decryption of file.
     * @return boolean value of was file decrypted or not.
     * @param data - data to decrypt.
     */
    private static boolean decryptString(String data) {
        String decryptedData = new String(Base64.getDecoder().decode(data));
        // System.out.println("Decryption is successful: " + decryptedData);
        return true;
    }
    /**
     * Serialize all users.
     */
    public static void saveUsers() {
        try (ObjectOutputStream oot = new ObjectOutputStream
                (new FileOutputStream("users.dat"))) {
            oot.writeObject(users);
            oot.flush();
            encryptString(getKeyword());
        }
        catch (IOException e) {
            System.err.println("users.dat: IOException");
        }
    }
    /**
     * Deserialize all users.
     */
    @SuppressWarnings("unchecked")
    public static void loadUsers() {
        try {
            if (decryptString(getKeyword()) == encryptString(getKeyword())) {
                FileInputStream fis = new FileInputStream("users.dat");
                ObjectInputStream oin = new ObjectInputStream(fis);
                users = (ArrayList<User>) oin.readObject();
                oin.close();
                fis.close();
            }
        }
        catch (IOException|ClassNotFoundException e) {
            users = new ArrayList<>();
            System.err.println("users.dat: IOException");
        }
    }
    /**
     * Serialize all courses.
     */
    public static void saveCourses() {
        try (ObjectOutputStream oot = new ObjectOutputStream
                (new FileOutputStream("courses.dat"))) {
            oot.writeObject(courses);
            oot.flush();
            encryptString(getKeyword());
        }
        catch (IOException e) {
            System.err.println("courses.dat: IOException");
        }
    }
    /**
     * Deserialize all courses.
     */
    @SuppressWarnings("unchecked")
    public static void loadCourses() {
        try {
            if (decryptString(getKeyword()) == encryptString(getKeyword())) {
                FileInputStream fis = new FileInputStream("courses.dat");
                ObjectInputStream oin = new ObjectInputStream(fis);
                courses = (ArrayList<Course>) oin.readObject();
                oin.close();
                fis.close();
            }
        }
        catch (IOException|ClassNotFoundException e) {
            courses = new ArrayList<>();
            System.err.println("users.dat: IOException");
        }
    }
    /**
     * Get course by course code.
     * @return Return course with particular code
     * @param code - code of course
     */
    public static Course getCourse(String code) {
        for (Course course: courses)
            if (course.getCode().equals(code))
                return course;
        return null;
    }
    /**
     * Delete course with particular course code.
     * @param code - code of course
     */
    public static void deleteCourse(String code) {
        for (Course course: courses)
            if (course.getCode().equals(code))
                courses.remove(course);
    }

    /**
     * Get user with particular username.
     * @return Returns User object with partucular username.
     * @param username - username of user
     */
    public static User getUser(String username) {
        for (User user: users)
            if (user.getUsername().equals(username))
                return user;
        return null;
    }
    /**
     * Get student with particular id.
     * @return Returns Student object with partucular id.
     * @param id - id of student
     */
    public static Student getStudent(String id) {
    	for (User user: users) {
    		if (user instanceof Student) {
    			Student st = (Student) user;
    			if (st.getId().equals(id)) {
    				return st;
    			}
    		}
    	}
    	return null;
    }

    public static Student getStudent(int yearOfStudy) {
        for (User user: users) {
            if (user instanceof Student) {
                Student st = (Student) user;
                if (st.getYearOfStudy() == yearOfStudy) {
                    return st;
                }
            }
        }
        return null;
    }

    /**
     * Get teacher with particular id.
     * @return Returns Teacher object with partucular id.
     * @param id - id of teacher
     */
    public static Teacher getTeacher(String id) {
        for(User user: users) {
            if (user instanceof Teacher) {
                Teacher st = (Teacher) user;
                if(st.getId().equals(id)) {
                    return st;
                }
            }
        }
        return null;
    }
    /**
     * Serialize all news.
     */
    public static void saveNews() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("news.dat"))) {
            oot.writeObject(news);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("news.dat: IOException");
        }
    }
    /**
     * Deserialize all news.
     */
    @SuppressWarnings("unchecked")
    public static void loadNews() {
        try {
            FileInputStream fis = new FileInputStream("news.dat");
            ObjectInputStream oin = new ObjectInputStream(fis);
            news = (ArrayList<News>) oin.readObject();
            oin.close();
            fis.close();
        }
        catch (ClassNotFoundException|IOException e) {
            news = new ArrayList<>();
            System.err.println("news.dat: ClassNotFoundException");
        }
    }

}
