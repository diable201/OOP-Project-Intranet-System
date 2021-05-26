import java.io.*;

public class Menu {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Database.loadUsers();
        Database.loadCourses();
        // Database.getAdmins();
        System.out.println(Database.getAdmins());
        System.out.println(Database.getStudents());
        System.out.println(Database.getTeachers());
        System.out.println(Database.getCourses());
        startSystem();
    }
    public static void startSystem() throws IOException, ClassNotFoundException {
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
                    // If the user object is found, then we let into the system
                    User user = menuLogin(reader);
                    if (user != null) {
                        while (user.getIsLogged()) {
                            if (user instanceof Admin) AdminMenu.menu(user, reader);
                            else if (user instanceof Student) StudentMenu.menu(user, reader);
                            else if (user instanceof Teacher) TeacherMenu.menu(user, reader);
                            else System.out.println("\nUsername or password incorrect. Please try again");
                        }
//
//
//
//                            else if (user instanceof ORManager)
//                                ManagerController.menu(user, reader);
//
//                            else if (user instanceof TechSupportGuy)
//                                SupportController.menu(user, reader);
                    } else {
                        System.out.println("\n[Unknown type of user]");
                    }
                } else if (input.equals("2")) {
                    System.out.println("\n[System closed]");
                    break;
                } else
                    System.out.println("\n[Incorrect input format. Please choose available option]");
            }

        } finally {
            System.exit(0);
        }
    }

    public static User menuLogin(BufferedReader reader) throws IOException {
        System.out.print("\nUsername: ");
        String username = reader.readLine();
        System.out.print("Password: ");
        String password = reader.readLine();
        User user = Database.getUser(username);
        if (user != null) {
            if (user.login(password)) return user;
        }
        return null;
    }

    public static void showMenuForChangePassword(User user, BufferedReader reader) throws IOException {
        System.out.print("""
                Changing password.
                Please enter new password:\s
                """);
        String password = reader.readLine();
        System.out.print("Please repeat your new password: ");
        String repeatedPassword = reader.readLine();
        System.out.println(checkAndChangePassword(user, password, repeatedPassword));
    }

    public static String checkAndChangePassword(User user, String password, String repeatedPassword) {
        if (password.equals(repeatedPassword)) {
            if (!password.equals(user.getPassword())) {
                user.setPassword(password);
                return "[Password successfully changed]";
            }
            else
                return "[This password is used now. Choose another]";
        }
        return "Passwords does not matches each other";
    }
}
