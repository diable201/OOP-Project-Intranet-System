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
                + "\n3. Manage requests"
                + "\n0. Logout";
        while (librarian.getIsLogged()) {
			System.out.println(librarianConsole);
			String option = reader.readLine();
			switch (option) {
				case "0":
					librarian.logout();
					System.out.println("\n[You logged out]");
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
									System.out.print("Please enter book name: ");
									String bookName = reader.readLine();

									System.out.print("Please enter book id: ");
									String bookId = reader.readLine();
									int id = Integer.parseInt(bookId);
									System.out.print("Please enter book author: ");
									String bookAuthor = reader.readLine();

									System.out.print("Please enter link to book: ");
									String bookLink = reader.readLine();

									librarian.addBooks(new Book(bookName, id, bookAuthor, bookLink));
									System.out.println("Book was created");
									break;
								case "2":
									System.out.println(librarian.getBooks());
									System.out.println("Please choose book id: ");
									bookId = reader.readLine();
									id = Integer.parseInt(bookId);
									if (librarian.deleteBooks(librarian.getBookById(id)))
										System.out.println("Book was deleted");
									else
										System.out.println("Book with that name doesn't exist");
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

//				case "3":
//                	while (true) {
//                		String manageOrdersMenu = "\n1. Accept orders"
//                								+"\n2. Reject Orders"
//                								+"\n0. Cancel";
//                		}
//                	}
			}
		}
    }
}


