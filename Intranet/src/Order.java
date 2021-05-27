import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (status != order.status) return false;
        return Objects.equals(book, order.book);
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        return result;
    }
}
