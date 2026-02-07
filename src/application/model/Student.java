package application.model;

public class Student
{
	private String firstName;
	private String lastName;
	private int matriculationNumber;
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

	public double getGradePointAvrage()
	{
		return gradePointAvrage;
	}

	public Student(String firstName, String lastName, int matriculationNumber, double gradePointAvrage)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.matriculationNumber = matriculationNumber;
		this.gradePointAvrage = gradePointAvrage;
	}
}
