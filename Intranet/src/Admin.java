import java.util.ArrayList;

/**
* @generated
*/
public class Admin extends Employee {

    public Admin() {
        super();
    }

    public Admin(String id, String name, String surname, EmployeeTypes department) {
        super(id, name, surname, department);
    }

    /**
    * @generated
    */
    private ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (User user: Database.users)
            if (user instanceof Student)
                students.add((Student)user);
        return students;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void viewLogFiles() {
        //TODO
    }
    /**
    * @generated
    */
    public boolean addUser(User u) {
        for (User user: Database.users)
            if (user.getUsername().equals(u.getUsername())) {
                return false;
            }
        Database.users.add(u);
        // Database.logFiles.add(new LogFile(LogType.USER_ADDED));
        return true;
    }
    /**
    * @generated
//     * @return
    */
    public boolean deleteUser(User user) {
        Database.users.remove(user);
        return true;
    }
    /**
    * @generated
    */
//    public void updateUser(User user, String newName, String newSurname) {
//    	if (users.contains(user)) {
//        user.setName(newName);
//        user.setSurname(newSurname);
//    	}
//    }
 

    public void updateStudentsYearOfStudy() {
        for (Student student: getStudents()) {
            student.increaseYearOfStudy();
            Database.users.remove(student);
            Database.users.add(student);
        }
    }

    @Override
    public String toString() {
        return "Admin{" +
                super.toString() +
                '}';
    }
}
