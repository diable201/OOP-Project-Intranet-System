import java.util.ArrayList;

/**
* @generated
*/
public class Librarian extends Employee {
    
    /**
    * @generated
    */
    private ArrayList<Book> books;
    private ArrayList<Order> orders;

    public Librarian() {
        super();
    }

    public Librarian(Integer id, String name, String surname, EmployeeTypes department) {
        super(id, name, surname, department);
    }

    /**
    * @generated
    */
    private Order order;
    
    /**
    * @generated
    */
    private Book book;
    
    
    /**
    * @generated
    */
    private ArrayList <Book> getBooks() {
        return this.books;
    }
    
    /**
    * @generated
    */
    private void setBooks(ArrayList <Book> books) {
        this.books = books;
    }
    
    
    /**
    * @generated
    */
    public Order getOrder() {
        return this.order;
    }
    
    /**
    * @generated
    */
    public void setOrder(Order order) {
        this.order = order;
    }
    
    /**
    * @generated
    */
    public Book getBook() {
        return this.book;
    }
    
    /**
    * @generated
    */
    public void setBook(Book book) {
        this.book = book;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void addBooks() {
        //TODO
    }
    /**
    * @generated
    */
    public void deleteBooks() {
        //TODO
    }
    /**
    * @generated
    */
    public void acceptRequest(Order order) {
        orders.add(order);
        order.setStatus(OrderStatus.NEW);
    }
    /**
    * @generated
    */
    public void rejectRequest(Order order) {
        orders.add(order);
        order.setStatus(OrderStatus.REJECTED);
    }
    
}
