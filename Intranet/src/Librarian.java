import java.util.ArrayList;

/**
* @generated
*/
public class Librarian extends Employee {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
    * @generated
    */
    private ArrayList<Book> books;
    private static ArrayList<Order> orders;

    public Librarian() {
        super();
    }

    public Librarian(String id, String name, String surname, EmployeeTypes department) {
        super(id, name, surname, department);
    }

    public ArrayList <Book> getBooks() {
        return this.books;
    }

    public void setBooks(ArrayList <Book> books) {
        this.books = books;
    }
    
    public static ArrayList <Order> getOrders() {
        return Librarian.orders;
    }

    public static void setOrders(ArrayList <Order> orders) {
        Librarian.orders = orders;
    }
    
    public static void addOrder(Order order) {
        Librarian.orders.add(order);
    }

    //                          Operations                                  

    public void addBooks(Book book) {
        books.add(book);
    }

    public void deleteBooks(Book book) {
        books.remove(book);
    }
  
    public void checkRequest(Order order) {
    	if(books.contains(order.getBook())) {
        order.setStatus(OrderStatus.ACCEPTED);
        orders.add(order); }
    	else {order.setStatus(OrderStatus.REJECTED);
        	orders.add(order); }
}
}
