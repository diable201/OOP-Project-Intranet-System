import java.io.BufferedReader;
import java.io.IOException;



public class TeacherMenu {

    static Teacher teacher = null;
    static BufferedReader reader = null;

    // Teacher menu
    public static void menu(User user, BufferedReader bufReader) throws IOException {

        teacher = (Teacher) user;
        reader = bufReader;

        while (user.getIsLogged()) {

            String teacherHomePage = "\n[Teacher: " + user.getFullName() + "]"
                    + "\n---------------------------------------"
                    + "\n1. Manage courses and files"
                    + "\n2. View students info/Put marks"
//                    + "\n3. Send/View messages to managers [Unread:" + Database.getUnreadMessagesToUser(teacher).size() + "]"
                    + "\n4. Change password"
                    + "\n0. Logout";


            System.out.println(teacherHomePage);
            String choice = reader.readLine();
            switch(choice) {
            	case "0" ->{
            		teacher.logout();
            		System.out.println("You are logged out!");
            		break;
            	}
            	case "1" ->{
            		if(teacher.getCourses().size()!=0) {
            			while(true) {
//            				for(Course c: teacher.getCourses()) {
							System.out.println(teacher.getCourses());
//            					c.toString();
//            				}
            				System.out.println("\n1. Manage course files " + "\n0. Exit");	
            				choice = reader.readLine();
            				if (choice.equals("0"))
    							break;
    						
    						else if (choice.equals("1")) 
    							TeacherMenu.manageCourseFiles();
            			}
            		}
            		else {
            			System.out.println("Teacher has no courses");
            		}
            	}
            	case "2"->{
            		if(teacher.getCourses().size()!=0) {
            			while(true) {
//            				for(Course c: teacher.getCourses()) {
            					System.out.println(teacher.getCourses());
//            				}
            				System.out.println("""

									1. Choose course
									0. Exit""");
            				choice = reader.readLine();
            				if(choice.equals("0")) {
            					break;
            				}
            				else if(choice.equals("1")){
            					TeacherMenu.chooseCourse();
            				}
            			}
            		}
            		else {
            			System.out.println("Teacher has no courses");
            		}
            	}
            	case "4" ->{
            		Menu.showMenuForChangePassword(user, reader);
                    break;
            	}
            		
            }
        }
    }
    public static void manageCourseFiles() throws IOException{
    	try {

			System.out.print("\nChoose code from the list: ");
			String choice = reader.readLine();
			Course course = Database.getCourse(choice);

			while(true) {
				
				System.out.println("1. Add file"
						 + "\n2. Delete file"
						 + "\n0. Exit back");
				choice = reader.readLine();
					
				if (choice.equals("1")) {
					System.out.print("Please enter file name: ");
					String fileName = reader.readLine();
						
					System.out.print("Please enter file content: ");
					String fileContent = reader.readLine();
						
					teacher.addFiles(course, new CourseFiles(fileName, fileContent));
					System.out.println("File was created");
				}
					
				else if (choice.equals("2")) {
						
					System.out.print("Please enter file name: ");
					String inputName = reader.readLine();
						
					if (teacher.deleteFiles(course, course.getFile(inputName)))
						System.out.println("File was deleted");
					else 
						System.out.println("File with that name doesn't exist");
					}
					
					else if (choice.equals("0"))
						break;
					
					else 
						System.out.println("Incorrect choice. Choose available one");
					
				} 
    	}catch (NullPointerException exception) {
    		System.out.println("[Incorrect name]\n");
    	}
    }
    public static void chooseCourse()  throws IOException{
    	try{
    		System.out.print("\nEnter code of course from the list: ");
			String choice = reader.readLine();
			Course course = Database.getCourse(choice);
			while(true) {
				System.out.println("\n1. Put student mark"+"\n0. Exit back");
				choice = reader.readLine();
				if(choice.equals("0")) {
					break;
				}
				else if(choice.equals("1")) {
					System.out.print("Enter student ID: ");
					String input = reader.readLine();
					Student student = Database.getStudent(input);
					assert course != null;
					if(course.getStudents().contains(student)) {
						assert student != null;
						System.out.println("Student: " + student.getFullName() +"/n");
						System.out.println("Choose type of mark" + "/n" +
						"/n1 First attestation" +
								"/n2 Second attestation" + 
								"/n3 Final" );
						input = reader.readLine();
						TypeOfMark tm = null;
						if (input.equals("1")) {
							tm = TypeOfMark.FIRST_ATTESTATION;
						}else if (input.equals("2")) {
							tm = TypeOfMark.SECOND_ATTESTATION;
						}else if (input.equals("3")) {
							tm = TypeOfMark.FINAL;
						}
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
    	}catch (NullPointerException exception){
    		System.out.println("[Incorrect name]\n");
    	}
    }
}

    

//		} catch (NumberFormatException exception) {
//			System.out.println("[Incorrect input format. Please enter number]\n");
//		} catch (NullPointerException exception) {
//			System.out.println("[Incorrect name]\n");
//		}
    	
    


//                            if (choice.equals("0"))
//                                break;

//                            else if (choice.equals("1"))
//                                TeacherController.manageCourseFiles();

//                            else
//                                System.out.println("\n[Incorrect input format. Please choose available option]\n");
//                        }
//                    } else {
//                        System.out.println("[There are no any courses, which you teach. Please wait, they will be added by manager very soon]");
//                        Controller.exitMessage(reader);
//                    }
//                    break;
//
                // 2 main menu option: view course students and put their marks
//                case "2":
//                    if (teacher.getTeachingCourses().size() > 0) {
//                        while (true) {

//                            Views.showCourses(teacher, 7, teacher.getTeachingCourses());
//
//                            String puttingMarksMenu = "\n1. Select course"
//                                    + "\n0. Exit to main menu";
//
//                            System.out.println(puttingMarksMenu);
//                            choice = reader.readLine();
//
//                            if (choice.equals("0"))
//                                break;
//                            else if (choice.equals("1"))
//                                TeacherController.putMarks();
//                            else
//                                System.out.println("\n[Incorrect input format. Please choose available option]\n");
//                        }
//                    } else {
//                        System.out.println("[There are no any courses, which you teach. Please wait, they will be added by manager very soon]");
//                        Controller.exitMessage(reader);
//                    }

//                    break;

                // 3 main menu option: manage messages to managers
//                case "3":
//
//                    while (true) {
//
//                        //                                + "\n3. View all incoming messages [Unread:" + Database.getUnreadMessagesToUser(teacher).size() + "]"
//                        String detailInfoMenu = """
//
//                                1. Send new message to manager
//                                2. View all sent messages
//                                0. Exit main""";
//
//                        System.out.println(detailInfoMenu);
//                        String option = reader.readLine();
//
//                        // Send new messages
////                        if (option.equals("1")) {
////
////                            if (Database.getManagers().size() > 0) {
////                                while (true) {
////
////
////                                    String detailSendingMenu = "\n1. Choose manager"
////                                            + "\n0. Exit back";
////
////                                    System.out.println(detailSendingMenu);
////                                    option = reader.readLine();
////
////                                    if (option.equals("1")) {
//////                                        TeacherController.sendMessageToManager();
//////                                        Controller.exitMessage(reader);
////                                    } else if (option.equals("0"))
////                                        break;
////                                    else
////                                        System.out.println("\n[Incorrect input format. Please choose available option]");
////
////                                }
////                            } else {
////                                System.out.println("[There are no any managers yet]");
////                            }
//                        }
//
//                        // View all sent messages
////                        else if (option.equals("2")) {
//
////                            Views.showSentMessages(Database.getMessagesFromUser(teacher));
////                            Controller.exitMessage(reader);
//
//                        }
//
//                        // View all incoming messages
////                        else if (option.equals("3")) {
//
////                            Views.showIncomingMessages(Database.getMessagesToUser(teacher));
////                            Controller.exitMessage(reader);
//                            for (Message message : Database.getMessagesToUser(user))
////                                message.setStatus(MessageStatus.READ);
//
//                        } else if (option.equals("0"))
//                            break;
//                        else
//                            System.out.println("\n[Incorrect input format. Please choose available option]");
//
//                    }
//                    break;
//
//                // 4 main menu option: manage orders to support
////                case "4":
//
//                    while (true) {
//
//                        String detailInfoMenu = """
//
//                                1. Send new order to support
//                                2. View all sent orders
//                                0. Exit main""";
//
//                        System.out.println(detailInfoMenu);
//                        String option = reader.readLine();
//
//                        // Send new order
//                        if (option.equals("1")) {
//
//                            System.out.print("\nPlease describe problem in order to make request to support (0 to exit back): ");
//                            String text = reader.readLine();
//
//                            if (!text.equals("0")) {
////                                teacher.sendOrder(new Order(teacher, text));
//                                System.out.println("[Your request has been sent to support]\n");
//
//                            }
//                        }
//
//                        // View all sent orders
//                        else if (option.equals("2")) {
////                            Views.showOrders(Database.getOrdersFromUser(teacher));
//
//                        } else if (option.equals("0"))
//                            break;
//
//                        else
//                            System.out.println("\n[Incorrect input format. Please choose available option]");
//
//                    }
//                    break;
//
//                // 5 main menu option: change password
//                case "5":
//                    Menu.showMenuForChangePassword(teacher, reader);
//                    break;
//                default:
//                    System.out.println("\n[Incorrect input format. Please choose available option]");
//                    break;
//            }
//
//        }
//    }
//
//    // ----------------------------------------------------------------------------
//    // Subcontrollers of individual stages of information input and processing
//    // Made to visually relieve the main controller
//    //-----------------------------------------------------------------------------
//
//
//    // Subcontroller: managing course files
//    public static void manageCourseFiles() throws IOException {
//
//        try {
//
//            System.out.print("\nPlease enter ID of course from the list: ");
//            String choice = reader.readLine();
//
//            int courseId = Integer.parseInt(choice);
////            Course course = Database.getCourse(courseId);
//
////            if (teacher.isTeachingCourse(course))
//
//                while(true) {
//
////                    Views.showCourseFiles(course);
//
//                    String managingFilesMenu = """
//                            1. Add new file
//                            2. Delete file
//                            0. Exit back""";
//
//                    System.out.println(managingFilesMenu);
//                    choice = reader.readLine();
//
//                    if (choice.equals("1")) {
//
//                        System.out.print("Please enter file name: ");
//                        String fileName = reader.readLine();
//
//                        System.out.print("Please enter file description: ");
//                        String fileDescription = reader.readLine();
//
////                        teacher.addCourseFile(course, new CourseFile(fileName, fileDescription));
//                        System.out.println("[File was successfully created]");
//                    }
//
//                    else if (choice.equals("2")) {
//
//                        System.out.print("Please enter file ID: ");
//                        String input = reader.readLine();
//
//                        int fileId = Integer.parseInt(input);
//
////                        if (teacher.deleteCourseFile(course, course.getCourseFile(fileId)))
////                            System.out.println("[File was successfully deleted]");
////                        else
////                            System.out.println("[File with that ID doesn't exist]");
//                    }
//
//                    else if (choice.equals("0"))
//                        break;
//
//                    else
//                        System.out.println("[Incorrect option. Choose available]");
//                }
//            else
//                System.out.println("[Course doesn't exist or it is not yours]\n");
//
//        } catch (NumberFormatException exception) {
//            System.out.println("[Incorrect input format. Please enter number]\n");
//        } catch (NullPointerException exception) {
//            System.out.println("[Incorrect ID number]\n");
//        }
//    }
//
//
//    // Subcontroller: view course students and putting their marks
//    public static void putMarks() throws IOException {
//
//        try {
//
//            System.out.print("\nPlease enter ID of course from the list: ");
//            String choice = reader.readLine();
//
//            int courseId = Integer.parseInt(choice);
////            Course course = Database.getCourse(courseId);
//
////            if (teacher.isTeachingCourse(course))
//
//                while(true) {
//
////                    Views.showCourseStudentsMarks(course, course.getStudents());
//
//                    String puttingMarksMenu = """
//
//                            1. Put student mark
//                            2. Search students by fullname pattern
//                            0. Exit back""";
//
//                    System.out.println(puttingMarksMenu);
//                    choice = reader.readLine();
//
//                    if (choice.equals("1")) {
//
//                        System.out.print("Please enter student ID: ");
//                        String input = reader.readLine();
//
//                        int studentId = Integer.parseInt(input);
////                        Student student = Database.getStudent(studentId);
//
////                        if (course.getStudents().contains(student)) {
////
////                            System.out.println("\n[Student name: " + student.getFullName() + "]");
//                            System.out.print("Please enter score (must be <= 100): ");
//
//                            input = reader.readLine();
//                            int studentScore = Integer.parseInt(input);
//
////                            if (teacher.putMark(course, student, new Mark(studentScore)))
////                                System.out.println("\n[Mark was successfully put]");
////                            else
////                                System.out.println("\n[Mark was not put. Please check score]");
//                        }
//                        else
//                            System.out.println("[Incorrect student ID]");
//                    }
//
////                    else if (choice.equals("2")) {
//
//                        System.out.print("\nPlease enter search pattern: ");
//                        String pattern = reader.readLine();
//
//                    }
//
////                    else if (choice.equals("0"))
////                        break;
//
////                    else
////                        System.out.println("[Incorrect option. Choose available]");
//
//                }
//            else
//                System.out.println("[Course doesn't exist or you it is not yours]\n");

//        } catch (NumberFormatException exception) {
//            System.out.println("[Incorrect input format. Please enter number]\n");
//        } catch (NullPointerException exception) {
//            System.out.println("[Incorrect ID number]\n");
//        }
//    }


    // Subcontroller: send message to manager
//    public static void sendMessageToManager() throws IOException {
//
//        try {
//            System.out.print("\nEnter manager ID: ");
//            String input = reader.readLine();
//            int managerId = Integer.parseInt(input);
//
////            System.out.println("\n[Receiver: " + Database.getManager(managerId).getFullName() + "]");
//            System.out.print("[Your message]: ");
//
//            String text = reader.readLine();
//
////            teacher.sendMessage(new Message(teacher, Database.getManager(managerId), text));
//
//            System.out.println("[Your message was successfully sent]");
//
//        } catch (NumberFormatException exception) {
//            System.out.println("[Incorrect input format]");
//        } catch (NullPointerException exception) {
//            System.out.println("[Incorrect ID number]");
//        } catch (ClassCastException exception) {
//            System.out.println("[Teacher with that id doesn't exist]");
//        }
//    }
//
//}
