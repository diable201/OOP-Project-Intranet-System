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
											+ "\n4. View all courses"
											+ "\n5. Regulation registration for students(open/close)"
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
			
			
//			if (Database.getTeachers().size() > 0) {
//				System.out.println("\nTeachers:");
//				Views.showTeachers(Database.getTeachers());
//	
//				System.out.print("\nEnter ID of teacher: ");
//				int teacherId = Integer.parseInt(reader.readLine());
//				Teacher teacher = Database.getTeacher(teacherId);
//				
//				if (teacher != null) {
//					if (manager.addNewCourse(new Course(title, credits, teacher, studyYear, studentsLimit, speciality)))
//						System.out.println("\n[Course was successfully created]");
//					else
//						System.out.println("\n[Course creation disrupted. The similar course is already created]");
//				}
//				else 
//					System.out.println("[Course creation disrupted. Incorrect teacher ID number]");
//			}
//			else 
//				System.out.println("[Course creation disrupted. There are no teachers]");
			Course c = new Course(code, title, credits, faculty);
			manager.addCourse(c);
			System.out.println("\n[Course was successfully created]");
    	}catch (NullPointerException exception) {
    		System.out.println("\n[Course creation disrupted]");
    	}
    }

}
