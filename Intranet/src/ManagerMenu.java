import java.io.BufferedReader;
import java.io.IOException;


public class ManagerMenu {

	static Manager manager = null;
    static BufferedReader reader = null;
    public static void menu(User user, BufferedReader bufReader) throws IOException {
    	manager= (Manager) user;
        reader = bufReader;
        
        while (user.getIsLogged()) {
        	System.out.println("\n[Manager: " + user.getFullName() + "]"
                    + "\n---------------------------------------"
                    + "\n1. Manage registration and courses"
                    + "\n2. View teachers and student info"
//                    + "\n3. Send/View messages to managers [Unread:" + Database.getUnreadMessagesToUser(teacher).size() + "]"
                    + "\n3. Change password"
                    + "\n0. Logout");
        	String choice = reader.readLine();
			switch(choice) {
				case "0"-> {
					manager.logout();
					System.out.println("You are logged out!");
				}
				case "1"-> {
					label1:
					while(manager.getIsLogged()) {
						System.out.println("""
	
								Manage registration and courses
								---------------------------------
								1. Create course
								2. Delete course
								3. View all courses
								4. Regulation registration for students(open/close)
								0. Exit""");
						String inp = reader.readLine();
						switch (inp) {
							case "0":
								break label1;
							case "1":
								ManagerMenu.createCourse();
								break label1;
							case "2":
								System.out.print(Database.getCourses());
								System.out.println("Choose course code:");
								String inputName = reader.readLine();
								Database.deleteCourse(inputName);
								System.out.print(Database.getCourses());
								break;
							case "3":
								System.out.print(Database.getCourses());
								break;
							case "4":
								if (manager.getRegistration()) {
									System.out.print("Registration is open");
									String actionsWithRegistration = """
	
											---------------------------------
											1. Close registration
											0. Cancel""";
									System.out.println(actionsWithRegistration);
									String action = reader.readLine();
									if (action.equals("0")) break label1;
									else if (action.equals("1")) manager.closeRegistration();
									System.out.println("Registration is closed now");
								}
								else {
									String actionsWithClosedRegistration = """
		
											---------------------------------
											1. Open registration
											0. Cancel""";
									System.out.print("Registration is closed");
									System.out.println(actionsWithClosedRegistration);
									String action = reader.readLine();
									if (action.equals("0")) {
										break label1;
									}
									else if (action.equals("1")) {
										manager.openRegistration();
									}
									System.out.println("Registration is open now");
								}
								break;
						}
        			}
				}
        		case "2" -> {
        			String usersInfo = """
	
							---------------------------------
							1. Teachers
							2. Students
							0. Cancel""";
				   System.out.println(usersInfo);
				   String inp = reader.readLine();
					switch (inp) {
						case "0":
							break;
						case "1":
							System.out.println(Database.getTeachers());
							break;
						case "2":
							String sort = """
	
									---------------------------------
									1. By GPA
									2. By name
									0. Cancel""";

							System.out.println(sort);
							String a = reader.readLine();
							if (a.equals("0")) {
								break;
							}
							else if (a.equals("2")) {
								System.out.println(Database.getStudentsListByName());
							}
							break;
					}
				}
				case "3" ->
					Menu.showMenuForChangePassword(user, reader);
			}
        }
    }
    public static void createCourse() throws IOException{
    	try {
    		String code;
    		String title;
    		int credits;
    		Faculty faculty = null;
    		System.out.println("Enter code: ");
    		code = reader.readLine();
    		
    		System.out.println("Enter title: ");
    		title = reader.readLine();
    		
    		System.out.print("Number of credits: ");
			credits = Integer.parseInt(reader.readLine());
			
			System.out.print("""
					Choose faculty:\s
					1. FIT
					2. BS
					3. MCM
					""");
			String input = reader.readLine();
			switch (input) {
				case "1" -> faculty = Faculty.FIT;
				case "2" -> faculty = Faculty.BS;
				case "3" -> faculty = Faculty.MCM;
			}
			System.out.println("\nTeachers:");
			System.out.println(Database.getTeachers());
			System.out.print("\nEnter ID of teacher: ");
			String teacherId = reader.readLine();
			Teacher teacher = Database.getTeacher(teacherId);
			System.out.println(teacher);
			if (manager.addCourse(new Course(code, title, credits, faculty, teacher))) {
				System.out.println("\n[Course was successfully created]");
			}
			else {
				System.out.println("\n[Course creation disrupted. The similar course is already created]");
			}
		} catch (ExceptionInInitializerError exception) {
    		System.out.println("[Course creation disrupted]\n");
    	}
    }
}
