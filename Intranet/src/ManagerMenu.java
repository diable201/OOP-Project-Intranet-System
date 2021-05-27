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
                    + "\n4. Change password"
                    + "\n0. Logout");
        	String choice = reader.readLine();
        	switch(choice) {
        	case "0"->{
        		manager.logout();
        		System.out.println("You are logged out!");
        		break;
        	}
        	case "1"->{
        		while(manager.getIsLogged()) {
        			System.out.println("\nManage registration and courses"
											+ "\n---------------------------------"
											+ "\n1. Create course"
											+ "\n2. Delete course"
											+ "\n3. View all courses"
											+ "\n4. Regulation registration for students(open/close)"
											+ "\n0. Exit");
        			String inp = reader.readLine();
        			if(inp.equals("0")) {
        				break;
        			}else if(inp.equals("1")) {
//        				if(manager.getTeachers().size()!=0) {
//        					ManagerMenu.createCourse();
//        				}
        				ManagerMenu.createCourse();
        			}
        			else if(inp.equals("2")) {
        				System.out.print(Database.getCourses());
        				System.out.println("Choose course code:");
        				String inputName = reader.readLine();
//        				Course delC = Database.getCourse(inputName);
        				Database.deleteCourse(inputName);
        				System.out.print(Database.getCourses());
        			}
        			else if(inp.equals("3")) 
        				System.out.print(Database.getCourses());
        			else if(inp.equals("4")) {
        				if(manager.getRegistration()) {
        				System.out.print("Registration is open");
        				String actionsWithRegistration = "\n---------------------------------"
        						+ "\n1. Close registration"
        						+ "\n0. Cancel" ;
        				System.out.println(actionsWithRegistration);
        				String action = reader.readLine();
;        				if (action.equals("0")) break;
        				else if(action.equals("1")) manager.closeRegistration();
						System.out.println("Registration is open now");
        				}
        				else System.out.print("Registration is closed"); {
        					String actionsWithClosedRegistration = "\n---------------------------------"
            						+ "\n1. Open registration"
            						+ "\n0. Cancel" ;
        					System.out.println(actionsWithClosedRegistration);
        					String action = reader.readLine();
        					if(action.equals("0")) 
        						break;
        					else if (action.equals("1")) 
        						manager.openRegistration();
        					System.out.println("Registration is open now");
        				}
        			}
        		}
        	}
        	case "3" -> {
        		String usersInfo = "\n---------------------------------"
        					+ "\n1. Teachers" 
        					+ "\n2. Students"
        					+ "\n0. Cancel" ;
        	   System.out.println(usersInfo);
        	   String inp = reader.readLine();
        	   if (inp.equals("0")) break;
        	   else if (inp.equals("1")) {
        		   System.out.println(Database.getTeachers());
        	   }
        	   else if (inp.equals("2")) {
        		   String sort = "\n---------------------------------"
        				   	+ "\n1. By GPA"
        				   	+ "\n2. By name"
        				   	+ "\n0. Cancel" ;
        	   
        		   System.out.println(sort);
        		   String a = reader.readLine();
        	   }
        	}
        	case "4" ->{
        		Menu.showMenuForChangePassword(user, reader);
                break;
        	}
        	
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
			
			System.out.print("Choose faculty: " + "\n"+
									"1. FIT" + "\n" +
									"2. BS" + "\n" +
									"3. MCM" + "\n");
			String input = reader.readLine();
			if(input.equals("1")) {
				faculty = Faculty.FIT;
			}else if(input.equals("2")) {
				faculty = Faculty.BS;
			}else if(input.equals("3")) {
				faculty = Faculty.MCM;
			}
			
			
			System.out.println("\nTeachers:");
			System.out.println(Database.getTeachers());

			System.out.print("\nEnter ID of teacher: ");
			String teacherId = reader.readLine();
			Teacher teacher = Database.getTeacher(teacherId);
			System.out.println(teacher);
			if (manager.addCourse(new Course(code, title, credits, faculty, teacher)))
				System.out.println("\n[Course was successfully created]");
			else
				System.out.println("\n[Course creation disrupted. The similar course is already created]");

//				System.out.println("[Course creation disrupted. Incorrect teacher ID number]");
		} catch (ExceptionInInitializerError exception){
    		System.out.println("[Course creation disrupted]\n");
    }

}
}
