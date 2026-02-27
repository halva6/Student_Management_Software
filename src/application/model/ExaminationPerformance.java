package application.model;

import java.io.Serializable;
import java.util.Arrays;

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
			grade = (attemptResults[i] < grade) ? attemptResults[i] : grade;
		}

		if (grade > 4.0)
		{
			this.passed = false;
		}

		this.grade = grade;
	}

	public String getExamName()
	{
		return examName;
	}

	public String getExamDescription()
	{
		return examDescription;
	}

	public String getExamType()
	{
		return examType;
	}

	public int getSemester()
	{
		return semester;
	}

	public double getGrade()
	{
		return grade;
	}

	public boolean isPassed()
	{
		return passed;
	}

	public double[] getResults()
	{
		return results;
	}

	public String[] getDates()
	{
		return dates;
	}

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