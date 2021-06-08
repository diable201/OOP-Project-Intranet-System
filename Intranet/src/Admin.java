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
        for (User user: Database.users) {
            if (user.getUsername().equals(u.getUsername())) {
                return false;
            }
        }
        Database.users.add(u);
        return true;
    }
    /**
    * @generated
    */
    public boolean deleteUser(User user) {
        Database.users.remove(user);
        return true;
    }

    public void updateStudentsYearOfStudy() {
        for (Student student: getStudents()) {
            student.increaseYearOfStudy();
            Database.users.remove(student);
            Database.users.add(student);
        }
    }

    @Override
    public String toString() {
        return "Admin: " + super.toString();
    }

    public void sentMessage() {

    }

    @Override
    public String getMessage() {
        StringBuilder ans = new StringBuilder();
        int messageCount = 0;
        for (Message message : Database.messages) {
            if (message.getReceiver().equals(this.getId())) {
                messageCount++;
                ans.append(messageCount).append(") Message for Admin from: ").append(message.getSender()).append("\n    " +
                        "Text: ").append(message.getBody()).append("\n");
            }
        }
        return ans.toString();
    }
}
