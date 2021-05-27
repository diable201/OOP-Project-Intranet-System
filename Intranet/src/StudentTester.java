import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentTester {
	
	private Student student;
	
	StudentTester(Student student){
		setStudent(student);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void studentConsole() throws ClassNotFoundException, IOException {
		while(true) {
			System.out.println("Hello " + student.getName() + "!");
			System.out.println("Select action:");
			System.out.println("1.Register for course.");
			System.out.println("2.Withdraw courses.");
			System.out.println("3.View transcript");
			System.out.println("4.View mark");
			System.out.println("5.Send Request to Library");
			System.out.println("6.View course files");
			System.out.println("7.Rate teachers");
			System.out.println("8.Exit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int input = Integer.parseInt(br.readLine());
			if(input == 1) {
				System.out.println("Choose course number:");
				for (int i = 1; i<= Database.courses.size(); i++) {
					System.out.println(i + ") " + Database.courses.get(i-1).getTitle());	
				}
				int choice = Integer.parseInt(br.readLine());
//				student.registerCourses(Database.courses.get(choice-1));
				}
			else if(input == 2) {
				System.out.println("Choose course number:");
				for (int i = 1; i<= student.getCourses().size(); i++) {
					System.out.println(i + ") " + student.getCourses().get(i-1).getTitle());	
				}
				int choice = Integer.parseInt(br.readLine());
				student.withdrawCourses(student.getCourses().get(choice-1));
				}
			else if(input == 3) {
				System.out.println("Your Transcript:");
				student.viewTranscript();
			}
			else if(input == 4) {
				System.out.println("Choose course number:");
				for (int i = 1; i<= student.getCourses().size(); i++) {
					System.out.println(i + ") " + student.getCourses().get(i-1).getTitle());	
				}
				int choice = Integer.parseInt(br.readLine());
				System.out.print(student.viewMark(student.getCourses().get(choice-1)));
				}
//			else if(input == 5) {
//				System.out.println("Send book name to Library:");
//				student.sendRequestToLibrary(null, null);
//			}
			else if(input == 6) {
				System.out.println("Choose course number to view its course files");
				for (int i = 1; i<= student.getCourses().size(); i++) {
					System.out.println(i + ") " + student.getCourses().get(i-1).getTitle());	
				}
				int choice = Integer.parseInt(br.readLine());
//				student.viewCourseFiles(student.getCourses().get(choice-1));
			}
			else if(input == 7) {
				System.out.println("Rate teachers");
			}
			
			
				
	
}
	}
}

