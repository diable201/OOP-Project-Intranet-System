/**
* @generated
*/
public class Order {

    public Order() {}

    public Order(Boolean status) {
        this.status = status;
    }

    /**
    * @generated
    */
    private Boolean status;
    
    
    /**
    * @generated
    */
    private Librarian librarian;
  
    /**
    * @generated
    */
    public Librarian getLibrarian() {
        return this.librarian;
    }
    
    /**
    * @generated
    */
    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }
    

    //                          Operations                                  

    /**
     * @generated
     */
    private Boolean getStatus() {
        return this.status;
    }

    /**
     * @generated
     */
    private void setStatus(Boolean status) {
        this.status = status;
    }
    
}
