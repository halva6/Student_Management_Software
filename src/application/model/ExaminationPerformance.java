package application.model;

import java.util.Arrays;

public class ExaminationPerformance
{
	private String examName;
	private String examDiscription;
	private String examType;
	private int semesterNumber;
	private double grade;
	private boolean passed = true;
	private int attemps;

	private double[] attemptResults = new double[3];
	private String[] attemptDates = new String[3];

	public ExaminationPerformance(String examName, String examDiscription, String examType, int semesterNumber, int attempts, double[] attemptResults, String[] attemptDates)
	{
		this.examName = examName;
		this.examDiscription = examDiscription;
		this.examType = examType;
		this.semesterNumber = semesterNumber;
		this.attemps = attempts;

		this.attemptResults = attemptResults;
		this.attemptDates = attemptDates;

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

	public String getExamDiscription()
	{
		return examDiscription;
	}

	public String getExamType()
	{
		return examType;
	}

	public int getSemesterNumber()
	{
		return semesterNumber;
	}

	public double getGrade()
	{
		return grade;
	}

	public boolean isPassed()
	{
		return passed;
	}

	public double[] getAttemptResults()
	{
		return attemptResults;
	}

	public String[] getAttemptDates()
	{
		return attemptDates;
	}

	public int getAttempts()
	{
		return attemps;
	}

	@Override
	public String toString()
	{
		return "ExaminationPerformance [examName=" + examName + ", examDiscription=" + examDiscription + ", examType=" + examType + ", semesterNumber=" + semesterNumber + ", grade=" + grade
				+ ", passed=" + passed + ", attemps=" + attemps + ", attemptResults=" + Arrays.toString(attemptResults) + ", attemptDates=" + Arrays.toString(attemptDates) + "]";
	}

}