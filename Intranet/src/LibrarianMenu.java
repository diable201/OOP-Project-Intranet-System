import java.io.BufferedReader;
import java.io.IOException;

public class LibrarianMenu {
    static Librarian librarian = null;
    static BufferedReader reader = null;
    public static void menu(User user, BufferedReader bf) throws IOException {
        librarian = (Librarian) user;
        reader = bf;
        String librarianConsole = "\nWelcome, Librarian: " + librarian.getFullName() + ""
                + "\n---------------------------------------"
                + "\n1. Change password"
                + "\n2. Manage books"
                + "\n3. Send message"
                + "\n4. Read message"
                + "\n5. View news"
                + "\n0. Logout";
        while (librarian.getIsLogged()) {
            System.out.println(librarianConsole);
            String option = reader.readLine();
            switch (option) {
                case "3":
                    System.out.println("Enter text: ");
                    String body = reader.readLine();
                    System.out.println("Enter your name: ");
                    String sender = reader.readLine();
                    System.out.println(Database.getEmployees());
                    System.out.println("Enter employee id you want to message to: ");
                    String receiver = reader.readLine();
                    librarian.sentMessage(body, sender, receiver);
                    System.out.println("Message was sent");
                    break;
                case "4":
                    System.out.println(librarian.getMessage());
                    break;
                case "5":
                    System.out.println(Database.getNews());
                    break;
                case "0":
                    librarian.logout();
                    System.out.println("\nYou logged out");
                    break;
                case "1":
                    Menu.showMenuForChangePassword(user, reader);
                    break;
                case "2":
                    try {
                        while (true) {
                            String manageBooksMenu = """
                                1. Add books
                                2. Delete books
                                3. View all books
                                0. Cancel""";
                            System.out.println(manageBooksMenu);
                            option = reader.readLine();
                            switch (option) {
                                case "0":
                                    break;
                                case "1":
                                    System.out.println("Please enter book name: ");
                                    String bookName = reader.readLine();
                                    System.out.println("Please enter book id: ");
                                    String bookId = reader.readLine();
                                    int id = Integer.parseInt(bookId);
                                    System.out.println("Please enter book author: ");
                                    String bookAuthor = reader.readLine();
                                    System.out.println("Please enter link to book: ");
                                    String bookLink = reader.readLine();
                                    librarian.addBooks(new Book(bookName, id, bookAuthor, bookLink));
                                    System.out.println("Book was created");
                                    break;
                                case "2":
                                    System.out.println(librarian.getBooks());
                                    System.out.println("Please choose book id: ");
                                    bookId = reader.readLine();
                                    id = Integer.parseInt(bookId);
                                    if (librarian.deleteBooks(librarian.getBookById(id))) {
                                        System.out.println("Book was deleted");
                                    }
                                    else {
                                        System.out.println("Book with that name doesn't exist");
                                    }
                                    break;
                                case "3":
                                    System.out.println(librarian.getBooks());
                                    break;
                                default:
                                    continue;
                            }
                            break;
                        }
                    } catch (IOException e) {
                        System.out.println("error");
                    }
            }
        }
    }
}