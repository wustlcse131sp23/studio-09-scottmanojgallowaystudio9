package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int studentID;
	private int attemptedCredits;
	private int passingCredits;
	private double qualityPoints;
	private double bearBucksBalance;
	public Student(String initFirstName, String initLastName, int initID)
	{
		firstName=initFirstName;
		lastName=initLastName;
		studentID=initID;
	}
	/**
	 * 
	 * @return full name
	 */
	public String getFullName()
	{
		return firstName+" "+lastName;
	}	
	/**
	 * 
	 * @return bear bucks balance
	 */
	public double getBearBucksBalance()
	{
		return bearBucksBalance;
	}
	/**
	 * 
	 * @return ID number
	 */
	public int getId()
	{
		return studentID;
	}
	/**
	 * 
	 * @return number of attempted credits
	 */
	public int getTotalAttemptedCredits()
	{
		return attemptedCredits;
	}
	/**
	 * 
	 * @return number of passing credits
	 */
	public int getTotalPassingCredits()
	{
		return passingCredits;
	}
	/**
	 * 
	 * @param amount amount to deposit
	 */
	public void depositBearBucks(double amount)
	{
		bearBucksBalance+=amount;
	}
	/**
	 * 
	 * @param amount amount to deduct
	 */
	public void deductBearBucks(double amount)
	{
		bearBucksBalance-=amount;
	}
	/**
	 * 
	 * @return refund amount after cashing out bear bucks
	 */
	public double cashOutBearBucks()
	{
		if (bearBucksBalance<=10)
			{
				bearBucksBalance=0;
				return 0.0;
			}
		else
			{
				double refundAmount=bearBucksBalance-10;
				bearBucksBalance=0;
				return refundAmount;
			}
	}
	/**
	 * 
	 * @param grade grade for a course taken
	 * @param credits number of credits of the course
	 */
	public void submitGrade(double grade, int credits)
	{
		qualityPoints+=grade*credits;
		if (grade>=1.7)
			{passingCredits+=credits;
			attemptedCredits+=credits;}
		else
			attemptedCredits+=credits;
	}
	/**
	 * 
	 * @return GPA
	 */
	public double calculateGradePointAverage()
	{
		double gpa=qualityPoints/attemptedCredits;
		return gpa;
	}
	/**
	 * 
	 * @return eligibility status for PBK
	 */
	public boolean isEligibleForPhiBetaKappa()
	{
		if (attemptedCredits>=98 && qualityPoints/attemptedCredits>=3.6)
			return true;
		else if (attemptedCredits>=75 && qualityPoints/attemptedCredits>=3.8)
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @return Class of student
	 */
	public String getClassStanding()
	{
		if (passingCredits<30)
			return "First Year";
		else if (passingCredits>=30 && passingCredits<60)
			return "Sophomore";
		else if (passingCredits>=60&&passingCredits<90)
			return "Junior";
		else
			return "Senior";
	}
	/**
	 * 
	 * @param firstName First name of child
	 * @param otherParent Other parent
	 * @param isHyphenated Whether the last name of child is hyphenated
	 * @param id Child student ID
	 * @return child
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id)
	{
		double value1=this.cashOutBearBucks();
		double value2=otherParent.cashOutBearBucks();
		if (isHyphenated==true)
			{String newLastName=this.lastName+"-"+otherParent.lastName;
			Student nepoBaby=new Student (firstName,newLastName,id);
			nepoBaby.depositBearBucks(value1+value2);
			return nepoBaby;
			}
		else
		{
			String newLastName=this.lastName;
			Student nepoBaby=new Student (firstName,newLastName,id);
			nepoBaby.depositBearBucks(value1+value2);
			return nepoBaby;
		}
	}
	public String toString()
	{
		return firstName+" "+lastName+": "+studentID;
	}
	
}
