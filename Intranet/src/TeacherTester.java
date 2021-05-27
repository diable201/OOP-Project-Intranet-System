public class TeacherTester {

	public static void main(String[] args) {
		Database d = Database.getInstance();
		Teacher t1 = new Teacher("10B010101", "Henry", "Cavill", EmployeeTypes.EDUCATIONAL, AcademicDegree.PROFESSOR);
		Teacher t2 = new Teacher("09C213247", "Gal", "Gadot", EmployeeTypes.EDUCATIONAL, AcademicDegree.PROFESSOR);
		
		t1.setFullName("Henry", "Cavill");
//		System.out.println(t1.getFullName());
//		System.out.println(t1.getAcademicDegree());
		t2.setFaculty(Faculty.FIT);
		t1.setFaculty(Faculty.FIT);
//		System.out.println(t2.getFaculty());
		
//		System.out.println("_______________________________________________");
		
		Course c1 = new Course("CSCI12", "WebDev", 4, Faculty.FIT, t1);
		Course c2 = new Course("CSCI11", "PP2", 4, Faculty.FIT, t2);
//		t1.setCourses(c1);
//		System.out.println(t1.getCourses());
		c1.setLimitOfStudents(85);
//		System.out.println(c1.getLimitOfStudents());
//		System.out.println(c2.getTitle());
		
		
//		t1.setCourses(c1);
//		t1.setCourses(c2);
//		t2.setCourses(c2);
		System.out.println(t2.getCourses());
		System.out.println(t1.getCourses());
//		System.out.println(t1.getCourses());
//		System.out.println("_______________________________________________");
//		System.out.println(t2.getCourses());
//		System.out.println("_______________________________________________");
		
			
		CourseFiles cf1 = new CourseFiles("WebDev Syllabus 2021", "Lab works, Lectures, Midterm and Project defence as endterm");
		CourseFiles cf2 = new CourseFiles("PP2 Syllabus 2021", "Midterm and Project defence as endterm, Final");
		CourseFiles cf3 = new CourseFiles("WebDev_Lecture10", "Something about Django");
		CourseFiles cf4 = new CourseFiles("PP2", "Something about Python");
		
//		t1.addFiles(c1, cf1);
//		t1.addFiles(c1, cf3);
//		t2.addFiles(c2, cf2);
//		t1.addFiles(c1, cf4);
		

//		System.out.println(t1.viewCourseFiles(c1));
//		System.out.println("_______________________________________________");
//		System.out.println(t2.viewCourseFiles(c2));
//		System.out.println("_______________________________________________");
//		t1.deleteFiles(c1, cf4);
//		System.out.println(t1.viewCourseFiles(c1));
//		System.out.println("_______________________________________________");
		
		Student s1 = new Student("19B010101", "Cortez", "Makhmut", 2, Faculty.FIT, Degree.BACHELOR);
		Student s2 = new Student("19B010102", "Diable", "Seitbekov", 2, Faculty.FIT, Degree.BACHELOR);
		Student s3 = new Student("19B010103", "Tolyander", "Tolegen", 2, Faculty.FIT, Degree.BACHELOR);

//		s1.setFullName(s1.getName(), s1.getSurname());
		s2.setFullName(s2.getName(), s2.getSurname());
//		s3.setFullName(s3.getName(), s3.getSurname());
//
		c2.setStudents(s1);
		c1.setStudents(s2);
		c1.setStudents(s3);
		c2.setStudents(s3);
//
//		s3.setCourses(c1);
//		s3.setCourses(c2);
		
//		System.out.println(t1.viewStudentsInfo(c1));
//		System.out.println("_______________________________________________");
		
		t1.putMark(c1, TypeOfMark.FIRST_ATTESTATION, 27, s3);
		t1.putMark(c1, TypeOfMark.SECOND_ATTESTATION, 26, s3);
		t1.putMark(c1, TypeOfMark.FINAL, 35, s3);
		

		t1.putMark(c2, TypeOfMark.FIRST_ATTESTATION, 30, s3);
		t1.putMark(c2, TypeOfMark.SECOND_ATTESTATION, 30, s3);
		t1.putMark(c2, TypeOfMark.FINAL, 34, s3);
		System.out.println("_______________________________________________");
		
		t1.putMark(c1, TypeOfMark.FINAL, 35, s1);
		System.out.println("_______________________________________________");
		System.out.println(t1.getMarksOfStudent(s3));
		System.out.println("_______________________________________________");
		System.out.println(t1.getMarksOfStudent(s1));
		
		System.out.println("_______________________________________________");
		System.out.println(t1.getMarksOfStudents(c1));
		
		System.out.println("_______________________________________________");
		System.out.println(s3.viewMark(c1));
		
		System.out.println("_______________________________________________");
		s3.viewTranscript();

		t1.putMark(c2, TypeOfMark.FIRST_ATTESTATION, 30, s3);
		t1.putMark(c2, TypeOfMark.SECOND_ATTESTATION, 30, s3);
		t1.putMark(c2, TypeOfMark.FINAL, 34, s3);
//		System.out.println("_______________________________________________");
		
		t1.putMark(c1, TypeOfMark.FINAL, 35, s1);
//		System.out.println("_______________________________________________");
//		System.out.println(t1.getMarksOfStudent(s3));
//		System.out.println("_______________________________________________");
//		System.out.println(t1.getMarksOfStudent(s1));
//
//		System.out.println("_______________________________________________");
//		System.out.println(t1.getMarksOfStudents(c1));
		
//		System.out.println("_______________________________________________");
//		System.out.println(s3.viewMark(c1));
		
//		System.out.println("_______________________________________________");
//		s3.viewTranscript2();
//		System.out.println(s3.viewCourseFiles2(c1));
	}

}
