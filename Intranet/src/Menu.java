import java.io.*;

public class Menu {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Database.loadUsers();
        Database.loadCourses();
        Database.loadNews();
//        // Database.getAdmins();
//        System.out.println(Database.getAdmins());
//        System.out.println(Database.getStudents());
//        System.out.println(Database.getTeachers());
//        System.out.println(Database.getLibrarians());
//        System.out.println(Database.getManagers());
//        System.out.println(Database.getCourses());
//        System.out.println(Database.getNews());
        startSystem();
    }
    public static void startSystem() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                String welcomePage = """

                        Welcome to Intranet!
                        1. Login
                        2. Exit""";

                System.out.println(welcomePage);
                String input = reader.readLine();
                if (input.equals("1")) {
                    User user = menuLogin(reader);
                    if (user != null) {
                        while (user.getIsLogged()) {
                            if (user instanceof Admin) AdminMenu.menu(user, reader);
                            else if (user instanceof Student) StudentMenu.menu(user, reader);
                            else if (user instanceof Teacher) TeacherMenu.menu(user, reader);
                            else if (user instanceof Manager) ManagerMenu.menu(user, reader);
                            else if (user instanceof Librarian) LibrarianMenu.menu(user, reader);
                            else System.out.println("\nUsername or password incorrect. Please try again");
                        }
                    } else {
                        System.out.println("\nError");
                    }
                } else if (input.equals("2")) {
                    System.out.println("\nSystem closed");
                    break;
                } else {
                    System.out.println("\nIncorrect input format. Please choose available option");
                }
            }

        } catch (IOException exception) {
            System.out.println("Exception");
        }
    }

    public static User menuLogin(BufferedReader reader) throws IOException {
        System.out.print("\nUsername: ");
        String username = reader.readLine();
        System.out.print("Password: ");
        String password = reader.readLine();
        User user = Database.getUser(username);
        if (user != null) {
            if (user.login(password)) {
                return user;
            }
        }
        return null;
    }

    public static void showMenuForChangePassword(User user, BufferedReader reader) throws IOException {
        System.out.print("""
                Changing password.
                Please enter new password:\s
                """);
        String password = reader.readLine();
        System.out.println("Please repeat your new password: ");
        String repeatedPassword = reader.readLine();
        System.out.println(checkAndChangePassword(user, password, repeatedPassword));
    }

    public static String checkAndChangePassword(User user, String password, String repeatedPassword) {
        if (password.hashCode() == (repeatedPassword.hashCode())) {
            if (!(password.hashCode() == (user.getPassword().hashCode()))) {
                user.setPassword(password);
                return "[Password successfully changed]";
            }
            else {
                return "This password is used now. Choose another";
            }
        }
        return "Passwords does not matches each other";
    }
}
