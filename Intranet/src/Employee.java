import java.util.ArrayList;

/**
* @generated
*/
public abstract class Employee extends User implements Messageable {
    
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

    public void sentMessage(String body, String sender, String receiver) {
        Message m = new Message(body, sender, receiver);
        Database.messages.add(m);
    }

    public String getMessage() {
        StringBuilder ans = new StringBuilder();
        int msgCount = 0;
        for (Message message : Database.messages) {
            if(message.getReceiver().equals(this.getId())) {
                msgCount ++;
                ans.append(msgCount).append(") Message from: ").append(message.getSender()).append("\n    " +
                        "Title: ").append(message.getIsRead()).append("\n    " +
                        "Text: ").append(message.getBody()).append("\n\n");
            }
        }
        return ans.toString();
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
