import java.util.*;

/**
 * The LabClass class represents an enrolment list for one lab class. It stores
 * the time, room and participants of the lab, as well as the instructor's name.
 * Modified to have ArrayList of Student also has an infinite capacity
 * @author Michael Kolling and David Barnes and Ian bradley
 * @version 28/09/2006
 */
public class LabClass
{
	private String instructor;
	private String room;
	private String timeAndDay;
	private ArrayList < Student > students;

	/**
	 * Create a LabClass with  no limit on number of enrolments. 
	 * All other details are set to default values.
	 */
	public LabClass()
	{
		instructor = "unknown";
		room = "unknown";
		timeAndDay = "unknown";
		students = new ArrayList < Student >();

	}

	/**
	 * Add a student to this LabClass.
	 * @param newStudent the student object to be enrolled
	 */
	public void enrollStudent(Student newStudent)
	{
		students.add(newStudent);
	}

	/**
	 * Return the number of students currently enrolled in this LabClass.
	 * @return the size of the class
	 */
	public int numberOfStudents()
	{
		return students.size();
	}

	/**
	 * Set the room number for this LabClass.
	 * @param roomNumber the room number for the class 
	 */
	public void setRoom(String roomNumber)
	{
		room = roomNumber;
	}

	/**
	 * Set the time for this LabClass. The parameter should define the day
	 * and the time of day, such as "Friday, 10am".
	 * @param timeAndDayString the time and day for the class
	 */
	public void setTime(String timeAndDayString)
	{
		timeAndDay = timeAndDayString;
	}

	/**
	 * Set the name of the instructor for this LabClass.
	 * @param instructorName the name of thje class instructor
	 */
	public void setInstructor(String instructorName)
	{
		instructor = instructorName;
	}

	/**
	 * Provides a class list with other LabClass details. 
	 * @return the class details
	 */
	public String getLabClass()
	{
		String myString = "Lab class " + timeAndDay + "\n";
		myString = myString + "Instructor: " + instructor + "   room: " + room
				+ "\n";
		myString = myString + "Class list:\n";

		for (Student student : students)
		{
			myString = myString + student.getStudentData() + "\n";
		}

		myString = myString + "\nNumber of students: " + numberOfStudents();
		return myString;
	}

	/**
	 * searches for a student by name.
	 * @param studentName name of student
	 * @return a student if found otherwise null
	 */
	public Student showStudent(String studentName)
	{
		for (Student student : students)
		{
			if (studentName.equals(student.getName()))
				return student;
		}
		return null;
	}

	/**
	 * removes a student from the list.
	 * @param studentName The name of the student to be deleted
	 * @return true if student deleted otherwise false
	 */
	public boolean removeStudent(String studentName)
	{
		int index = 0;
		for (Student student : students)
		{
			if (studentName.equals(student.getName()))
			{
				students.remove(index);
				return true;
			}
			index++;
		}
		return false;
	}

}
