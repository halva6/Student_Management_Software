package application.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Represents the performance of a student in a specific examination.
 *
 * <p>
 * This class stores details about the examination, including results of up to
 * three attempts, the best grade, and whether the exam was passed. It also
 * calculates the final grade based on the best attempt result.
 * </p>
 */
public class ExaminationPerformance implements Serializable
{
	private static final long serialVersionUID = 23L;

	private String examName;
	private String examDescription;
	private String examType;
	private int semester;
	private double grade;
	private boolean passed = true;
	private int attempts;

	private double[] results = new double[3];
	private String[] dates = new String[3];

	/**
	 * Creates a new ExaminationPerformance with given data.
	 *
	 * <p>
	 * The best result of the provided attempts is used as the final grade. If the
	 * grade is worse than 4.0, the examination is marked as not passed.
	 * </p>
	 *
	 * @param examName        the name of the examination
	 * @param examDiscription the description of the examination
	 * @param examType        the type of the examination
	 * @param semesterNumber  the semester in which the exam was taken
	 * @param attempts        the number of attempts
	 * @param attemptResults  an array containing results of attempts
	 * @param attemptDates    an array containing dates of attempts
	 */
	public ExaminationPerformance(String examName, String examDiscription, String examType, int semesterNumber, int attempts, double[] attemptResults, String[] attemptDates)
	{
		this.examName = examName;
		this.examDescription = examDiscription;
		this.examType = examType;
		this.semester = semesterNumber;
		this.attempts = attempts;

		this.results = attemptResults;
		this.dates = attemptDates;

		double grade = attemptResults[0];

		for (int i = 0; i < attempts; i++)
		{
			// source [10]
			grade = (attemptResults[i] < grade) ? attemptResults[i] : grade;
		}

		if (grade > 4.0)
		{
			this.passed = false;
		}

		this.grade = grade;
	}

	/**
	 * Returns the name of the examination.
	 *
	 * @return the exam name
	 */
	public String getExamName()
	{
		return examName;
	}

	/**
	 * Returns the description of the examination.
	 *
	 * @return the exam description
	 */
	public String getExamDescription()
	{
		return examDescription;
	}

	/**
	 * Returns the type of the examination.
	 *
	 * @return the exam type
	 */
	public String getExamType()
	{
		return examType;
	}

	/**
	 * Returns the semester number.
	 *
	 * @return the semester
	 */
	public int getSemester()
	{
		return semester;
	}

	/**
	 * Returns the final grade
	 *
	 * @return the grade
	 */
	public double getGrade()
	{
		return grade;
	}

	/**
	 * Indicates whether the examination was passed.
	 *
	 * @return {@code true} if passed, otherwise {@code false}
	 */
	public boolean isPassed()
	{
		return passed;
	}

	/**
	 * Returns the results of all attempts.
	 *
	 * @return an array of attempt results
	 */
	public double[] getResults()
	{
		return results;
	}

	/**
	 * Returns the dates of all atempts
	 *
	 * @return an array of attempt dates
	 */
	public String[] getDates()
	{
		return dates;
	}

	/**
	 * Returns the number of attempts.
	 *
	 * @return the attempts count
	 */
	public int getAttempts()
	{
		return attempts;
	}

	@Override
	public String toString()
	{
		return "ExaminationPerformance [examName=" + examName + ", examDiscription=" + examDescription + ", examType=" + examType + ", semesterNumber=" + semester + ", grade=" + grade + ", passed="
				+ passed + ", attempts=" + attempts + ", attemptResults=" + Arrays.toString(results) + ", attemptDates=" + Arrays.toString(dates) + "]";
	}

}