import java.util.ArrayList;

/**
* @generated
*/
public class Employee extends User {
    
    /**
    * @generated
    */
    private EmployeeTypes department;
    private ArrayList<Message> messages;
    public Employee() {
        super();
    }

    public Employee(Integer id, String name, String surname, EmployeeTypes department) {
        super(id, name, surname);
        this.department = department;
    }

    /**
    * @generated
    */
    private EmployeeTypes getDepartment() {
        return this.department;
    }
    
    /**
    * @generated
    */
    private void setDepartment(EmployeeTypes department) {
        this.department = department;
    }

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void sendMessage(Message message) {
        this.messages.add(message);
    }
    /**
    * @generated
    */
    public void viewIncomingMessage() {
        //TODO
    }
    /**
    * @generated
    */
    public ArrayList<Message> viewSentMessage() {
        return this.messages;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
