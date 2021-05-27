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
        while (user.getIsLogged()) {
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
                	while (true) {
                		String manageBooksMenu = "\n1. Add books"
                								+"\n2. Delete books"
                								+"\n0. Cancel";
                		System.out.print(manageBooksMenu);
                		option = reader.readLine();
                		if (option.equals("0")) 
                			break; 
                		else if (option.equals("1")) {
                			System.out.println(librarian.getBooks());
                			System.out.print("Please enter book name: ");
        					String bookName = reader.readLine();
        					
        					System.out.print("Please enter book id: ");
        					String bookId = reader.readLine();
        					int id = Integer.parseInt(bookId);
        					System.out.print("Please enter book author: ");
        					String bookAuthor = reader.readLine();
        						
        					System.out.print("Please enter link to book: ");
        					String bookLink = reader.readLine();
        						
        					librarian.addBooks(new Book(bookName, id, bookAuthor, bookLink)) ;
        					System.out.println("Book was created"); 
                		}
                		else if (option.equals("2")) {
                			System.out.print("Please choose book name: ");
                			String inputName = reader.readLine();
    						
        					if (librarian.deleteBooks(librarian.getBookByName(inputName)))
        						System.out.println("Book was deleted");
        					else 
        						System.out.println("Book with that name doesn't exist");
        					}
                		}
//                case "3":
//                	while (true) {
//                		String manageOrdersMenu = "\n1. Accept orders"
//                								+"\n2. Reject Orders"
//                								+"\n0. Cancel";
//                		}
                	}
}
}
}


