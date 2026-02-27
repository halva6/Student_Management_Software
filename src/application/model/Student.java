package application.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable
{
	private static final long serialVersionUID = 42L;
	
	private String firstName;
	private String lastName;
	private int matriculationNumber; // TODO Unique machen der Matrikel-Nummber, also wenn die schon vergeben ist,
										// soll sie nicht nochmal vergeben sein
	private String studyProgram;
	private String eMail;

	private ArrayList<ExaminationPerformance> examinationPerformances = new ArrayList<ExaminationPerformance>();
	private double gradePointAvrage = 0;

	public Student(String firstName, String lastName, int matriculationNumber, String studyProgram, String eMail, ArrayList<ExaminationPerformance> examinationPerformances)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.matriculationNumber = matriculationNumber;
		this.studyProgram = studyProgram;
		this.eMail = eMail;
		this.examinationPerformances = examinationPerformances;

		for (ExaminationPerformance examinationPerformance : examinationPerformances)
		{
			gradePointAvrage += examinationPerformance.getGrade();
		}

		try
		{
			gradePointAvrage /= examinationPerformances.size();
		} catch (ArithmeticException e)
		{
			e.printStackTrace();
			System.out.println("There are no examination performances.");
		}

	}
	
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

	public ArrayList<ExaminationPerformance> getExaminationPerformances()
	{
		return examinationPerformances;
	}

	@Override
	public String toString()
	{
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", matriculationNumber=" + matriculationNumber + ", studyProgram=" + studyProgram + ", eMail=" + eMail
				+ ", examinationPerformances=" + examinationPerformances + ", gradePointAvrage=" + gradePointAvrage + "]";
	}
}
