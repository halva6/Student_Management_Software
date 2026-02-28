package application.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a student with personal data and examination performances.
 *
 * <p>
 * This class stores information such as name, matriculation number, study
 * program, email, and a list of examination performances. It also calculates
 * the grade point average based on the stored examination results.
 * </p>
 * 
 * <p>
 * The {@link java.io.Serializable} interface is used to make it easy to save
 * this class to a file later and to read it back from that file.
 * </p>
 */
//source [25]
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

	/**
	 * Creates a new Student with given data and examination performances.
	 *
	 * <p>
	 * The grade point average is calculated based on the grades of all examination
	 * performances. If no performances are provided, the average remains zero.
	 * </p>
	 *
	 * @param firstName               the student's first name
	 * @param lastName                the student's last name
	 * @param matriculationNumber     the unique matriculation number
	 * @param studyProgram            the study program
	 * @param eMail                   the email address
	 * @param examinationPerformances the list of examination performances
	 */
	// source [11]
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

		// source [7]
		try
		{
			gradePointAvrage /= examinationPerformances.size();

			// source [12]
		} catch (ArithmeticException e)
		{
			e.printStackTrace();
			System.out.println("There are no examination performances.");
		}

	}

	/**
	 * Returns the student's first name.
	 *
	 * @return the first name
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * Returns the student's last name.
	 *
	 * @return the last name
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * Returns the matriculation number.
	 *
	 * @return the matriculation number
	 */
	public int getMatriculationNumber()
	{
		return matriculationNumber;
	}

	/**
	 * Returns the study program.
	 *
	 * @return the study program
	 */
	public String getStudyProgram()
	{
		return studyProgram;
	}

	/**
	 * Returns the email address.
	 *
	 * @return the email
	 */
	public String getEMail()
	{
		return eMail;
	}

	/**
	 * Returns the grade point average.
	 *
	 * @return the grade point average
	 */
	public double getGradePointAvrage()
	{
		return gradePointAvrage;
	}

	/**
	 * Returns the list of examination performances.
	 *
	 * @return the examination performances
	 */
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
