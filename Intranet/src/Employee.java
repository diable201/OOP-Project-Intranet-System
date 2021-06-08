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

    abstract public String getMessage();

    @Override
    public int compareTo(User user) {
        Employee employee = (Employee) user;
        if (super.compareTo(user) == 0)
            return department.compareTo(employee.department);
        return super.compareTo(user);
    }

    @Override
    public String toString() {
        return super.toString() + "department = " + department;
    }
}
