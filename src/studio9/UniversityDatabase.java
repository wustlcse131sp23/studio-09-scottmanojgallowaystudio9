package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	
	private final Map<String,Student> studData;
	public UniversityDatabase()
	{
		studData=new HashMap<>();
	}

	public void addStudent(String accountName, Student student) {
		studData.put(accountName, student);
	}

	public int getStudentCount() {
		
		return studData.size();
	}

	public String lookupFullName(String accountName) {
		if (studData.get(accountName)!=null)
			return studData.get(accountName).getFullName();
		else
			return null;
	}

	public double getTotalBearBucks() {
		double money=0;
		for(String accName:studData.keySet())
		{
			money+=studData.get(accName).getBearBucksBalance();
		}
		return money;
	}
}
