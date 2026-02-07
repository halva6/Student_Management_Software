package application.model;

import java.util.Arrays;

public class ExaminationPerformance
{
	private double results[] = new double[3];
	private String dates[] = new String[3];

	public double getAvrage()
	{
		int avrageCount = 0;
		double avrageSum = 0;
		for (double result : results)
		{
			if (result != 0)
			{
				avrageSum += result;
				avrageCount++;
			}
		}

		if (avrageCount != 0)
		{
			return avrageSum / avrageCount;
		}
		
		return -1;

	}

	public void addExam(double result, String date, int attempt)
	{
		results[attempt] = result;
		dates[attempt] = date;
	}

	public double getResult(int attempt)
	{
		return results[attempt];
	}

	public String getDate(int attempt)
	{
		return dates[attempt];
	}

	@Override
	public String toString()
	{
		return "ExaminationPerformance [results=" + Arrays.toString(results) + ", dates=" + Arrays.toString(dates)
				+ "]";
	}
}
