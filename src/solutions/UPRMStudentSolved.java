package solutions;
import java.util.ArrayList;

public class UPRMStudentSolved {
	
	private String studentId;
	private String firstName;
	private String lastName;
	private String academicProgram;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private double gpa;

	//Constructor
	public UPRMStudentSolved(String studentId, String firstName, String lastName) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Getters
	public String getStudentId() {return studentId;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getAcademicProgram() {return academicProgram;}
	public int getBirthDate() {return birthDay;}
	public int getBirthMonth() {return birthMonth;}
	public int getBirthYear() {return birthYear;}
	public double getGpa() {return gpa;}
	
	//Setters
	public void setAcademicProgram(String academicProgram) {this.academicProgram = academicProgram;}
	public void setGpa(double gpa) {this.gpa = gpa;}
	public void setBirthDate(int day, int month, int year) {
		this.birthDay = day;
		this.birthMonth = month;
		this.birthYear = year;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof UPRMStudentSolved) {
			UPRMStudentSolved s = (UPRMStudentSolved) o;
			return s.getStudentId().equals(this.getStudentId());
		}
		return false;
	}
		
	/*
	 * Returns the UPRMStudent with the highest GPA among all students in the given roster.
	 * Returns null if the roster is empty
	 */
	public static UPRMStudentSolved maxGPA(UPRMStudentSolved[] roster) {
		if(roster.length == 0) {return null;}
		UPRMStudentSolved target = roster[0];
		for(int i = 1; i < roster.length; i++) {
			if(roster[i].getGpa() > target.getGpa()) {target = roster[i];}
		}
		return target;
	}
	
	/*
	 * Returns true if all students in the roster have a GPA higher or equal that that of the target student
	 * Stops searching as soon as a student is found with lower GPA than the target
	 */
	public boolean allWithHigherGPA(UPRMStudentSolved[] roster) {
		if(roster.length == 0) {return true;}
		for(int i = 1; i < roster.length; i++) {
			if(roster[i].getGpa() < this.getGpa()) {return false;}
		}
		return true;
	}
	
	/*
	 * Returns a new array of students containing only those students from the given roster that belong
	 * to the given academic program
	 * The resulting array must not contain any null entries
	 * Returns empty array (length == 0) if no students belong to the program
	 */
	public static UPRMStudentSolved[] filterByProgram(String program, UPRMStudentSolved[] roster) {
		ArrayList<UPRMStudentSolved> result = new ArrayList<UPRMStudentSolved>();
		for(int i = 0; i < roster.length; i++) {
			if(roster[i].getAcademicProgram() == program) {result.add(roster[i]);}
		}
		return result.toArray(new UPRMStudentSolved[0]);
	}

	/* Returns the new course roster resulting from adding the
	 * target student at the end of the original roster
	 * You may assume that the target student is not already in 
	 * the course.
	 */
	public UPRMStudentSolved[] append(UPRMStudentSolved[] courseRoster) {
		ArrayList<UPRMStudentSolved> result = new ArrayList<UPRMStudentSolved>();
		for(int i = 0; i < courseRoster.length; i++) {
			result.add(courseRoster[i]);
		}
		result.add(this);
		return result.toArray(new UPRMStudentSolved[0]);
	}
}
