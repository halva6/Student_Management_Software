package application.model;

public class Student
{
	private String firstName;
	private String lastName;
	private int matriculationNumber;
	private String studyProgram;
	private String eMail;
	
	private ExaminationPerformance examinationPerformance;
	private double gradePointAvrage;

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public int getMatriculationNumber()
	{
		return matriculationNumber;
	}
	
	public String getStudyProgram() 
	{
		return studyProgram;
	}
	
	public String getEMail() 
	{
		return eMail;
	}
	
	public double getGradePointAvrage() 
	{
		return gradePointAvrage;
	}
	
	public ExaminationPerformance getExaminationPerformance() 
	{
		return examinationPerformance;
	}

	public Student(String firstName, String lastName, int matriculationNumber, String studyProgram, String eMail, ExaminationPerformance examinationPerformance)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.matriculationNumber = matriculationNumber;
		this.studyProgram = studyProgram;
		this.eMail = eMail;
		this.examinationPerformance = examinationPerformance;
		this.gradePointAvrage = examinationPerformance.getAvrage();
	}

	@Override
	public String toString()
	{
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", matriculationNumber="
				+ matriculationNumber + ", studyProgram=" + studyProgram + ", eMail=" + eMail
				+ ", examinationPerformance=" + examinationPerformance.toString() + "]";
	}
}
