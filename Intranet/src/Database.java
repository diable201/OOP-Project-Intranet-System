import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Base64;
/**
* @generated
*/
public class Database implements Serializable {
    
    /**
    * @generated
    */
    protected static ArrayList<User> users = new ArrayList<>();
    protected static ArrayList<Course> courses = new ArrayList<>();
    // protected static ArrayList<LogFile> logs = new ArrayList<LogFile>();
    protected static HashMap<Course, Mark> marks = new HashMap<>();
    protected static ArrayList<News> news = new ArrayList<>();
    protected static ArrayList<Message> messages = new ArrayList<>();
    protected static boolean registrationIsOpen = true;

    protected static String getKeyword() {
        return "Test";
    }

    private static Database INSTANCE = null;

    private Database() {}

    public static Database getInstance() {
        if (INSTANCE == null) INSTANCE = new Database();
        return INSTANCE;
    }

    public static void serUsers() throws IOException{
        FileOutputStream fos = new FileOutputStream("users.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public  static void desUsers() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("users.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        users = (ArrayList<User>) oin.readObject();
        oin.close();
        fis.close();
		for (User u : users) {
			System.out.println(u);
		}
    }

    public static void serCourses() throws IOException {
        FileOutputStream fos = new FileOutputStream("courses.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(courses);
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public  static void desCourses() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("courses.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        courses = (ArrayList<Course>) oin.readObject();
        oin.close();
        fis.close();
    }

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

    public static String getCourses() {
        StringBuilder s = new StringBuilder();
        for (Course course: courses) {
            if (course != null) {
                s.append(course.toString()).append("\n");
            }
        }
        return s.toString();
    }

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

    private static boolean encryptString(String data) {
        Base64.getEncoder().encodeToString((data.getBytes()));
        // System.out.println("Encryption is successful: " + encryptedData);
        return true;
    }

    private static boolean decryptString(String data) {
        String decryptedData = new String(Base64.getDecoder().decode(data));
        // System.out.println("Decryption is successful: " + decryptedData);
        return true;
    }

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
//        for (User u : users) {
//            System.out.println(u);
//        }
    }

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

    public static Course getCourse(String code) {
        for (Course course: courses)
            if (course.getCode().equals(code))
                return course;
        return null;
    }

    public static ArrayList<Message> getMessagesToUser(User user) {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Message message: messages)
            if (message.getReceiver().equals(user))
                allMessages.add(message);
        return allMessages;
    }

    public static ArrayList<Message> getMessagesFromUser(User user) {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Message message: messages)
            if (message.getSender().equals(user))
                allMessages.add(message);
        return allMessages;
    }

    public static User getUser(String username) {
        for (User user: users)
            if (user.getUsername().equals(username))
                return user;
        return null;
    }
    public static Student getStudent(String id) {
    	for(User user: users) {
    		if (user instanceof Student) {
    			Student st = (Student) user;
    			if(st.getId().equals(id)) {
    				return st;
    			}
    		}
    	}
    	return null;
    }

    public void addNews(News news) {
        Database.news.add(news);
    }

    private static void saveNews() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("news.dat"))) {
            oot.writeObject(news);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("news.dat: IOException");
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadNews() {
        try {
            FileInputStream fis = new FileInputStream("news.txt");
            ObjectInputStream oin = new ObjectInputStream(fis);
            news = (ArrayList<News>) oin.readObject();
            oin.close();
            fis.close();
        }
        catch (ClassNotFoundException|IOException e) {
            news = new ArrayList<>();
            System.err.println("news.txt: ClassNotFoundException");
        }
    }

}
