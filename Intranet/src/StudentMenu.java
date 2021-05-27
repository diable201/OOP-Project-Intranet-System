import java.io.BufferedReader;
import java.io.IOException;

public class StudentMenu {

    static Student student = null;
    static BufferedReader reader = null;

    // Student menu
    public static void menu(User user, BufferedReader bufReader) throws IOException {

        student = (Student)user;
        reader = bufReader;

        String studentHomePage  = "\n[Student: " + student.getFullName() + "]"
                + "\n---------------------------------------"
                + "\n1. View my courses info/files"
                + "\n2. Manage registration for courses"
                + "\n3. View transcript"
                + "\n4. Change password"
                + "\n0. Logout";

        while (student.getIsLogged()) {

            System.out.println(studentHomePage);
            String choice = reader.readLine();

            // Option: log out of account
            if (choice.equals("0")) {
                student.logout();
                System.out.println("\n[You logged out]");
            }

            // 2 main menu option: view registered courses and their files
            else if (choice.equals("1"))

                if (student.getCourses().size() >= 1)
                    while (true) {
                        String menuCoursesInfo  = """

                                1. View course files\s
                                0. Exit to main menu""";

                        System.out.println(menuCoursesInfo);
                        System.out.println(student.getCourses());
                        choice = reader.readLine();

                        // Back to main menu
                        if (choice.equals("0"))
                            break;

//                             View course files
                        else if (choice.equals("1")) {
                            StudentMenu.checkCourseFiles();

                        }
                        else
                            System.out.println("\n[Incorrect input format. Please choose available option]\n");
                    }
                else {
                    System.out.println("[There are no any registered courses yet]");

                }


            // 2 main menu option: managing registration for courses
            else if (choice.equals("2"))

                if (Database.registrationIsOpen)
//
                    while (true) {
//
                        if (student.getCoursesForRegistration().size() > 0) {
                            System.out.println(student.getCoursesForRegistration());
//
                            String manageRegistrationMenu = """

                                    1. Add course for registration
                                    2. Delete course from registration
                                    0. Exit to main menu""";

                            System.out.println(manageRegistrationMenu);
                            choice = reader.readLine();

                            // Back to main menu
                            if (choice.equals("0"))
                                break;

                                // Add/Delete course in registration
                            else if (choice.equals("1") || choice.equals("2")) {
                                StudentMenu.processCourseRegistrationOptions(choice);
                            }
                            else
                                System.out.println("\n[Incorrect input format. Please choose available option]\n");
                        }
                        else {
                            System.out.println("[There are no any courses available for registration yet. Please wait, they will be added by manager very soon ]");
                            break;
                        }
                    }

                else {
                    System.out.println("[Registration for courses is closed]");
                }
//
//
//                // 3 main menu option: view transcript
            else if (choice.equals("3")) {
                student.viewTranscript();

            }
//
            // 4 main menu option: change password
            else if (choice.equals("4"))
                Menu.showMenuForChangePassword(user, reader);
//
//            else
//                System.out.println("\n[Incorrect input format. Please choose available option]");
        }
    }

    // Subcontroller: processing choosed option for course registration
    public static void processCourseRegistrationOptions(String option) throws IOException {

        try {
            System.out.print("\nPlease enter ID of course from the list: ");
//            String input = reader.readLine();

            String courseId =  reader.readLine();

            if (option.equals("1"))
                if (student.registerForCourse(Database.getCourse(courseId)))
                    System.out.println("[Successfully added to registration]\n");
                else
                    System.out.println("[Incorrect course ID, course is full or you are already registered for this course]\n");
//
//            else if (option.equals("2"))
//                if (student.unregisterFromCourse(Database.getCourse(courseId)))
//                    System.out.println("[Successfully deleted from registration]\n");
//                else
//                    System.out.println("[Incorrect course ID or you weren't registered for the course]\n");

        } catch (NumberFormatException exception) {
            System.out.println("[Incorrect input format. Please enter ID number]\n");
        } catch (NullPointerException exception) {
            System.out.println("[Incorrect ID number]\n");
        }
    }

    public static void checkCourseFiles() throws IOException {

        try {

            System.out.print("\nPlease enter ID of course from the list: ");
//            String choice = reader.readLine();
            String courseId = reader.readLine();
            Course course = Database.getCourse(courseId);
            if (student.isHavingCourse(course)) {
                assert course != null;
                System.out.println(student.viewCourseFiles(course));
            } else {
                System.out.println("Error");
            }
        } catch (NumberFormatException exception) {
            System.out.println("[Incorrect input format. Please enter number]\n");
        }
    }

}
