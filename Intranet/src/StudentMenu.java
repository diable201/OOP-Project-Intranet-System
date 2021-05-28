import java.io.BufferedReader;
import java.io.IOException;

public class StudentMenu {
    static Student student = null;
    static BufferedReader reader = null;
    public static void menu(User user, BufferedReader bufReader) throws IOException {

        student = (Student)user;
        reader = bufReader;
        String studentHomePage  = "\nWelcome, Student: " + student.getFullName() + "]"
                + "\n---------------------------------------"
                + "\n1. View my courses info/files"
                + "\n2. Manage registration for courses"
                + "\n3. View transcript"
                + "\n4. Change password"
                + "\n5. Rate teachers"
                + "\n6. View news"
                + "\n0. Logout"
                + "\n---------------------------------------";

        while (student.getIsLogged()) {
            System.out.println(studentHomePage);
            String choice = reader.readLine();
            switch (choice) {
                case "0":
                    student.logout();
                    System.out.println("\n[You logged out]");
                    break;
                case "1":
                    if (student.getCourses().size() >= 1)
                        while (true) {
                            String menuCoursesInfo = """

                                    1. View course files\s
                                    0. Exit to main menu""";

                            System.out.println(menuCoursesInfo);
                            System.out.println(student.getCourses());
                            choice = reader.readLine();
                            if (choice.equals("0"))
                                break;
                            else if (choice.equals("1")) {
                                StudentMenu.checkCourseFiles();

                            } else
                                System.out.println("\n[Incorrect input format. Please choose available option]\n");
                        }
                    else {
                        System.out.println("[There are no any registered courses yet]");

                    }
                    break;

                case "2":
                    if (Database.registrationIsOpen)
                        while (true) {
                            if (student.getCoursesForRegistration().size() > 0) {
                                System.out.println(student.getCoursesForRegistration());
                                String manageRegistrationMenu = """

                                        1. Add course for registration                                   
                                        0. Exit to main menu""";

                                System.out.println(manageRegistrationMenu);
                                choice = reader.readLine();
                                if (choice.equals("0"))
                                    break;

                                else if (choice.equals("1") || choice.equals("2")) {
                                    StudentMenu.processCourseRegistrationOptions(choice);
                                } else
                                    System.out.println("\n[Incorrect input format. Please choose available option]\n");
                            } else {
                                System.out.println("[There are no any courses available for registration yet. Please wait, they will be added by manager very soon ]");
                                break;
                            }
                        }

                    else {
                        System.out.println("[Registration for courses is closed]");
                    }
                    break;
                case "3":
                    student.viewTranscript();

                    break;
                case "4":
                    Menu.showMenuForChangePassword(user, reader);
                    break;
                case "5":
                    System.out.println(Database.getTeachers());
                    System.out.print("Please enter teacher id: ");
                    String teacherId = reader.readLine();
                    Teacher teacher = Database.getTeacher(teacherId);
                    System.out.print("Please enter rate: ");
                    String rating = reader.readLine();
                    double ratingInt = Double.parseDouble(rating);
                    assert teacher != null;
                    student.rateTeachers(teacher, ratingInt);
                    System.out.println("Thanks for the rate.");
                    break;
                case "6":
                    System.out.println(Database.getNews());
            }
        }
    }

    public static void processCourseRegistrationOptions(String option) throws IOException {
        try {
            System.out.print("\nPlease enter ID of course from the list: ");
            String courseId =  reader.readLine();

            if (option.equals("1"))
                if (student.registerForCourse(Database.getCourse(courseId))) {
                    System.out.println("[Successfully added to registration]\n");
                }
                else {
                    System.out.println("[Incorrect course ID, course is full or you are already registered for this course]\n");
                }
        } catch (NumberFormatException exception) {
            System.out.println("[Incorrect input format. Please enter ID number]\n");
        } catch (NullPointerException exception) {
            System.out.println("[Incorrect ID number]\n");
        }
    }

    public static void checkCourseFiles() throws IOException {
        try {
            System.out.print("\nPlease enter ID of course from the list: ");
            String courseId = reader.readLine();
            Course course = Database.getCourse(courseId);
            if (student.isHavingCourse(course)) {
                assert course != null;
                System.out.println(student.viewCourseFiles(course));
            } else {
                System.out.println("Error");
            }
        } catch (NumberFormatException exception) {
            System.out.println("Error");
        }
    }
}
