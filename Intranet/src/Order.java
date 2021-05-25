/**
* @generated
*/
public class Order {

    public Order() {}

    public Order(OrderStatus status) {
        this.status = status;
    }

    /**
    * @generated
    */
    private OrderStatus status;
    private Book book;

    //                          Operations                                  

    /**
     * @generated
     */
    public OrderStatus getStatus() {
        return this.status;
    }

    /**
     * @generated
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    
    public void setBook(Book book) {
    	this.book = book;
    }
    
    public Book getBook() {
    	return this.book;
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                '}';
    }
}
