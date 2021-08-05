import java.util.ArrayList;
import java.util.Objects;

/**
* @generated
*/
public class Librarian extends Employee {
    /**
    * @generated
    */
    private ArrayList<Book> books = new  ArrayList<Book>();
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

    public Book getBookById(Integer id) {
        for (Book b : books) {
            if (b.getId().equals(id))
                return b;
        }
        return null;
    }

    //                          Operations

    public void addBooks(Book book) {
        books.add(book);
    }

    public boolean deleteBooks(Book book) {
        if (books.contains(book)) {
            return books.remove(book);
        }
        return false;
    }

    public void checkRequest(Order order) {
        if (books.contains(order.getBook())) {
            order.setStatus(OrderStatus.ACCEPTED);
        }
        else {
            order.setStatus(OrderStatus.REJECTED);
        }
        orders.add(order);
    }

    public void sentMessage() {

    }

    @Override
    public String getMessage() {
        StringBuilder ans = new StringBuilder();
        int messageCount = 0;
        for (Message message : Database.messages) {
            if (message.getReceiver().equals(this.getId())) {
                messageCount++;
                ans.append(messageCount).append(") Message for Librarian from: ").append(message.getSender()).append("\n    " +
                        "Text: ").append(message.getBody()).append("\n");
            }
        }
        return ans.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Librarian librarian = (Librarian) o;

        return Objects.equals(books, librarian.books);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Librarian: " + super.toString();
    }
}
