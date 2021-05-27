import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class AdminMenu {
    static Admin admin = null;
    static BufferedReader reader = null;
    public static void menu(User user, BufferedReader bf) throws IOException {
        admin = (Admin) user;
        reader = bf;
        String adminConsole = "\nWelcome, Admin: " + admin.getFullName() + ""
                + "\n---------------------------------------"
                + "\n1. Change password"
                + "\n2. Manage all users"
                + "\n3. View log files"
                + "\n4. Send message"
                + "\n5. Read message"
                + "\n6. View news"
                + "\n0. Logout";

        while (admin.getIsLogged()) {
            System.out.println(adminConsole);
            String option = reader.readLine();
            switch (option) {
                case "0":
                    admin.logout();
                    System.out.println("\n[You logged out]");
                    break;
                case "4":
                    System.out.println("Enter text: ");
                    String body = reader.readLine();
                    System.out.println("Enter your name: ");
                    String sender = reader.readLine();
                    System.out.println(Database.getEmployees());
                    System.out.println("Enter employee id you want to message to: ");
                    String receiver = reader.readLine();
                    admin.sentMessage(body, sender, receiver);
                    System.out.println("Message was sent");
                    break;
                case "5":
                    System.out.println(admin.getMessage());
                    break;
                case "6":
                    System.out.println(Database.getNews());
                    break;
                case "1":
                    Menu.showMenuForChangePassword(user, reader);
                    break;
                case "2":
                    while (true) {
                        String menuCreationUser = """

                                1. Create new user
                                2. Delete user
                                3. Update users info
                                4. View all users
                                0. Exit to main menu""";

                        System.out.println(menuCreationUser);
                        option = reader.readLine();
                        switch (option) {
                            case "0":
                                break;
                            case "1": {
                                String userTypeInfo = """

                                        1. Student
                                        2. Teacher
                                        3. Manager
                                        4. Admin
                                        0. Cancel""";

                                System.out.println(userTypeInfo);
                                option = reader.readLine();

                                if (option.equals("0")) {
                                    continue;
                                }
                                else if (option.equals("1") || option.equals("2")
                                        || option.equals("3") || option.equals("4")
                                        || option.equals("5")) {
                                    AdminMenu.addUser(option);
                                    break;
                                }
                                else {
                                    System.out.println("\nPlease choose other option\n");
                                }
                                break;
                            }
                            case "2":
                                Database.getStudents();
                                System.out.print("""
                                        (Enter 0 to cancel, 
                                        Enter 1 to continue)                  
                                        """);
                                option = reader.readLine();
                                try {
                                    if (option.equals("1")) {
                                        System.out.println("Enter Username of user, which you need to delete:");
                                        String username = reader.readLine();
                                        if (admin.deleteUser(Database.getUser(username))) {
                                            System.out.println("User was deleted");
                                            Database.saveUsers();
                                        }
                                        else {
                                            System.out.println("Can't find this username.");
                                        }
                                    }
                                } catch (NullPointerException exception) {
                                    System.out.println("Incorrect number");
                                }
                                break;
                            case "3":
                                String userOption = """

                                        1. Increase students study year
                                        0. Exit to main menu""";

                                System.out.println(userOption);
                                option = reader.readLine();
                                if (option.equals("0")) {
                                    break;
                                }
                                else if (option.equals("1")) {
                                    admin.updateStudentsYearOfStudy();
                                    System.out.println("All students study year has been increased");
                                } else {
                                    System.out.println("\nPlease choose other option.\n");
                                }
                                break;
                            case "4":
                                System.out.println(Database.getStudents());
                                System.out.println(Database.getManagers());
                                System.out.println(Database.getAdmins());
                                System.out.println(Database.getTeachers());
                            break;
                            default:
                                System.out.println("\nPlease choose other option.\n");
                            break;
                        }
                        break;
                    }

                default:
                    break;
                    // TODO log files
//                case "2":
//                    Views.showLogs(Database.logFiles);
//                    break;
            }
        }
    }
    public static void addUser(String userType) {
        try {
            String name, surname;
            User user = null;
            System.out.println("Name: ");
            name = reader.readLine();
            System.out.println("Surname: ");
            surname = reader.readLine();
            System.out.println("id: ");
            String id = reader.readLine();
            switch (userType) {
                case "1" -> {
                    System.out.print("Degree: ");
                    ArrayList<Degree> degreeList = new ArrayList<>();
                    int counterOfDegree = 1;
                    for (Degree degree: Degree.values()) {
                        System.out.print("\n" + (counterOfDegree++) + ". " + degree);
                        degreeList.add(degree);
                    }

                    System.out.print("\nEnter only one option: ");
                    String option = reader.readLine();
                    Degree degree = null;
                    int choice = Integer.parseInt(option.strip());
                    if (choice <= Degree.values().length && choice > 0) {
                        degree = degreeList.get(choice - 1);
                    }

                    ArrayList<Faculty> faculties = new ArrayList<>();
                    int counterOfFaculty = 1;
                    for (Faculty faculty : Faculty.values()) {
                        System.out.print("\n" + (counterOfFaculty++) + ". " + faculty);
                        faculties.add(faculty);
                    }

                    System.out.print("\nEnter Faculty: ");
                    option = reader.readLine();
                    Faculty faculty = null;
                    choice = Integer.parseInt(option.strip());
                    if (choice <= Faculty.values().length && choice > 0) {
                        faculty = faculties.get(choice - 1);
                    }
                    System.out.print("Enter Study year: ");
                    int yearOfStudy = Integer.parseInt(reader.readLine());
                    if (yearOfStudy >= 1 && yearOfStudy <= 7) {
                        user = new Student(id, name, surname, yearOfStudy, faculty, degree);
                    }
                    else {
                        System.out.println("User Creation Failed.");
                        return;
                    }
                }
                case "2" -> {
                    System.out.print("Teacher Degree: ");
                    int counterOfDegree = 1;
                    ArrayList<AcademicDegree> academicDegreeList = new ArrayList<>();
                    for (AcademicDegree teacherDegree : AcademicDegree.values()) {
                        System.out.print("\n" + (counterOfDegree++) + ". " + teacherDegree);
                        academicDegreeList.add(teacherDegree);
                    }
                    System.out.print("\nEnter Degree: ");
                    String option = reader.readLine();
                    AcademicDegree teacherDegree;
                    int choice = Integer.parseInt(option.strip());
                    if (choice <= AcademicDegree.values().length && choice > 0) {
                        teacherDegree = academicDegreeList.get(choice - 1);
                        user = new Teacher(id, name, surname, EmployeeTypes.EDUCATIONAL, teacherDegree);
                    } else {
                        System.out.println("Error.");
                        return;
                    }
                }
                case "3" -> user = new Manager(id, name, surname, EmployeeTypes.MANAGEMENT);
                case "4" -> user = new Admin(id, name, surname, EmployeeTypes.ADMINISTRATION);
            }
            if (admin.addUser(user)) {
                Database.saveUsers();
                System.out.println("User was successfully created");
            }
            else {
                System.out.println("Error. There is a user with the same username.");
            }
        } catch (IOException|NumberFormatException|NullPointerException exception) {
            System.out.println("Something bad happened. Please, try again.");
        }
    }
}
