import java.util.ArrayList;

/**
* @generated
*/
public abstract class Employee extends User {
    
    /**
    * @generated
    */
    private EmployeeTypes department;

    public Employee() {
        super();
    }

    public Employee(String id, String name, String surname, EmployeeTypes department) {
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
        Database.messages.add(message);
    }
    /**
    * @generated
    */
    public ArrayList<Message> viewIncomingMessage() {
        return Database.getMessagesFromUser(this);
    }
    /**
    * @generated
    */
    public ArrayList<Message> viewSentMessage() {
        return Database.getMessagesToUser(this);
    }

    @Override
    public int compareTo(User user) {
        Employee employee = (Employee) user;
        if (super.compareTo(user) == 0)
            return department.compareTo(employee.department);
        return super.compareTo(user);
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "department=" + department +
                '}';
    }
}
