/**
* @generated
*/
public class Employee extends User {
    
    /**
    * @generated
    */
    private EmployeeTypes department;

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

    public Employee() {
        super();
    }

    public Employee(Integer id, String name, String surname, EmployeeTypes department) {
        super(id, name, surname);
        this.department = department;
    }


    //                          Operations                                  
    
    /**
    * @generated
    */
    public sendMessage() {
        //TODO
    }
    /**
    * @generated
    */
    public viewIncomingMessage() {
        //TODO
    }
    /**
    * @generated
    */
    public viewSentMessage() {
        //TODO
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
