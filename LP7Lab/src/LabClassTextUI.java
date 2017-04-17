import java.util.*;

/**
 * Provides a text based user interface for the LabClass project.
 * 
 * @author Ian Bradley 
 * @version 14-03-2008
 */
public class LabClassTextUI {
	// instance variables - replace the example below with your own
	private LabClass labClass;
	Scanner myScanner;

	/**
	 * Constructor for objects of class TextUI
	 */
	public LabClassTextUI()
	{
		labClass = new LabClass();
		myScanner = new Scanner(System.in);
	}

	/**
	 * provides the main user interface with the program
	 */
	public void menu()
	{
		String command;
		do
		{
			displayMenu();
			command = getCommand();
			execute(command);
		}
		while (!command.equals("Quit"));
	}

	/**
	 * displays the menu string on the terminal display
	 */
	private void displayMenu()
	{
		String menuString = "Your Choices are :\n";
		menuString += "     Display full class details       [Full]\n";
		menuString += "     Find student by name             [Find]\n";
		menuString += "     Remove student by name         [Remove]\n";

		menuString += "     Set Instructor             [Instructor]\n";
		menuString += "     Set Room                         [Room]\n";
		menuString += "     Set Time and Day                 [Time]\n";
		menuString += "     Add student                       [Add]\n";
		menuString += "     Quit                             [Quit]\n";
		menuString += "Enter Choice : ";
		System.out.print(menuString);

	}

	/**
	 *  obtains the user's command
	 *  one command per line
	 *  @return the user command
	 */
	private String getCommand()
	{
		return myScanner.nextLine();
	}

	/**
	 * processes the legal commands
	 * @param command the command entered by the user
	 */
	private void execute(String command) 
	{
		if (command.equals("Quit"))
			System.out.println("Bye");
		else
			if (command.equals("Full"))
				System.out.println(labClass.getLabClass());
			else
				try{
					if (command.equals("Find"))
					{
						System.out.print("Enter student name : ");
						String studentName = myScanner.nextLine();
						if (studentName.length()==0){
								throw new Exception("empty string");
						}
						Student myStudent = labClass.showStudent(studentName);
						
						if (myStudent == null)
							//System.out.println("Student with name " + studentName+ " not  found");
							throw new NullPointerException("No such student exists");
						else
							System.out.println(myStudent.getStudentData());
					}

					else
						if (command.equals("Remove"))
						{
							System.out.print("Enter student name : ");
							String studentName = myScanner.nextLine();
							if (labClass.removeStudent(studentName))
								System.out.println("Student with name "
										+ studentName + " removed from class list");
							else 
								throw new NullPointerException("No such student exists");

						}
					else
						if (command.equals("Add"))
						{
							System.out.print("Enter student name : ");
							String studentName = myScanner.nextLine();
							System.out.print("Enter student id : ");
							String studentID = myScanner.nextLine();
							labClass.enrollStudent(new Student(studentName,
									studentID));
						}
						else
							if (command.equals("Instructor"))
							{
								System.out.print("Enter name of Instructor : ");
								String instructorName = myScanner.nextLine();
								labClass.setInstructor(instructorName);
							}
							else
								if (command.equals("Room"))
								{
									System.out.print("Enter Room : ");
									String room = myScanner.nextLine();
									labClass.setRoom(room);
								}
								else
									if (command.equals("Time"))
									{
										System.out.print("Enter lab time : ");
										String time = myScanner.nextLine();
										labClass.setTime(time);
									}
									else
										throw new Exception("no menu choice selected");
					}
				catch(NullPointerException e){
					System.out.println("Student Not Found");
				}
				catch(Exception e){
					System.out.println("\nPlease select valid choice\n");
				}
	}

}
