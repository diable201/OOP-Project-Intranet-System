import java.util.ArrayList;

/**
* @generated
*/
public class Admin extends Employee {

    public Admin() {
        super();
    }

    public Admin(Integer id, String name, String surname, EmployeeTypes department) {
        super(id, name, surname, department);
    }

    /**
    * @generated
    */
    private ArrayList <User> users;

    /**
    * @generated
    */
    private ArrayList<User> getUsers() {
        return this.users;
    }
    
    /**
    * @generated
    */
    private void setUsers(ArrayList <User> users) {
        this.users = users;
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
    public void addUser(User user) {
        this.checkStatus(user);
    }
    /**
    * @generated
    */
    public void deleteUser(User user) {
        if (user instanceof Teacher) {
            users.remove(user);
        }
        else if (user instanceof Student) {
            users.remove(user);
        }

    }
    /**
    * @generated
    */
    public void updateUser() {
        //TODO
    }

    private void checkStatus(User user) {
        if (user instanceof Teacher) {
            Teacher teacher = (Teacher) user;
            //Add to Database
            users.add(teacher);
        }
        else if (user instanceof Student) {
            Student student = (Student) user;
            //Add to Database
            users.add(student);
        }
    }
}
