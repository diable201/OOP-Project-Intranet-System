import java.io.BufferedReader;
import java.io.IOException;

public class TeacherMenu {
    static Teacher teacher = null;
    static BufferedReader reader = null;

    public static void menu(User user, BufferedReader bufReader) throws IOException {
        teacher = (Teacher) user;
        reader = bufReader;
        while (user.getIsLogged()) {
            String teacherHomePage = "\nWelcome, Teacher: " + user.getFullName() + ""
                    + "\n---------------------------------------"
                    + "\n1. Manage courses and files"
                    + "\n2. View students info/Put marks"
                    + "\n3. Change password"
					+ "\n4. View Rating"
					+ "\n5. Send message"
					+ "\n6. Read message"
					+ "\n7. View news"
                    + "\n0. Logout"
					+ "\n---------------------------------------";
            System.out.println(teacherHomePage);
            String choice = reader.readLine();
            switch(choice) {
            	case "0" -> {
            		teacher.logout();
            		System.out.println("You are logged out!");
				}
            	case "1" -> {
            		if (teacher.getTeachingCourses().size() != 0) {
            			while (true) {
							System.out.println(teacher.getTeachingCourses());
            				System.out.println("""
									1. Manage course files\s
									0. Exit""");
            				choice = reader.readLine();
            				if (choice.equals("0")) {
								break;
							}
    						else if (choice.equals("1")) {
								TeacherMenu.manageCourseFiles();
							}
            			}
            		}
            		else {
            			System.out.println("Teacher has no courses");
            		}
            	}
            	case "2" -> {
            		if (teacher.getTeachingCourses().size() != 0) {
            			while (true) {
            					System.out.println(teacher.getTeachingCourses());
            				System.out.println("""
									1. Choose course
									0. Exit""");
            				choice = reader.readLine();
            				if (choice.equals("0")) {
            					break;
            				}
            				else if (choice.equals("1")) {
            					TeacherMenu.chooseCourse();
            				}
            			}
            		}
            		else {
            			System.out.println("Teacher has no courses");
            		}
            	}
            	case "3" -> Menu.showMenuForChangePassword(user, reader);
            	case "4" -> System.out.println(teacher.getRate());
            	case "5" -> {
					System.out.println("Enter text: ");
					String body = reader.readLine();
					System.out.println("Enter your name: ");
					String sender = reader.readLine();
					System.out.println(Database.getEmployees());
					System.out.println("Enter employee id you want to message to: ");
					String receiver = reader.readLine();
					teacher.sentMessage(body, sender, receiver);
					System.out.println("Message was sent");
				}
				case "6" -> System.out.println(teacher.getMessage());
            	case "7" -> System.out.println(Database.getNews());
            }
        }
    }
    public static void manageCourseFiles() throws IOException{
    	try {
			System.out.print("\nChoose code from the list: ");
			String choice = reader.readLine();
			Course course = Database.getCourse(choice);
			label:
			while(true) {
				
				System.out.println("""
						1. Add file
						2. Delete file
						0. Exit back""");
				choice = reader.readLine();

				switch (choice) {
					case "1":
						System.out.print("Please enter file name: ");
						String fileName = reader.readLine();

						System.out.print("Please enter file content: ");
						String fileContent = reader.readLine();

						assert course != null;
						teacher.addFiles(course, new CourseFiles(fileName, fileContent));
						System.out.println("File was created");
						break;
					case "2":

						System.out.print("Please enter file name: ");
						String inputName = reader.readLine();

						assert course != null;
						if (teacher.deleteFiles(course, course.getFile(inputName)))
							System.out.println("File was deleted");
						else
							System.out.println("File with that name doesn't exist");
						break;
					case "0":
						break label;
					default:
						System.out.println("Incorrect choice. Choose available one");
						break;
				}
			}
		} catch (NullPointerException exception) {
    		System.out.println("Error\n");
    	}
    }

    public static void chooseCourse() throws IOException{
    	try {
    		System.out.print("\nEnter code of course from the list: ");
			String choice = reader.readLine();
			Course course = Database.getCourse(choice);
			while(true) {
				System.out.println("""
						1. Put student mark
						0. Exit back""");
				choice = reader.readLine();
				if (choice.equals("0")) {
					break;
				}
				else if (choice.equals("1")) {
					System.out.println(Database.getStudents());
					System.out.print("Enter student ID: ");
					String input = reader.readLine();
					Student student = Database.getStudent(input);
					assert course != null;
					if(course.getStudents().contains(student)) {
						assert student != null;
						System.out.println("Student: " + student.getFullName() +"\n");
						System.out.println("""
								Choose type of mark
								1. First attestation
								2. Second attestation
								3. Final""");
						input = reader.readLine();
						TypeOfMark tm = switch (input) {
							case "1" -> TypeOfMark.FIRST_ATTESTATION;
							case "2" -> TypeOfMark.SECOND_ATTESTATION;
							case "3" -> TypeOfMark.FINAL;
							default -> null;
						};
						System.out.println("Please enter your mark");
						input = reader.readLine();
						double studentPoint = Double.parseDouble(input);
						teacher.putMark(course, tm, studentPoint, student);
						System.out.println("Mark was added");
					}
					else {
						System.out.println("Student doesn't exist");
					}
				}
			}
    	} catch (NullPointerException exception){
    		System.out.println("Error");
    	}
    }
}
