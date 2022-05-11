package survey;


public class Survey 
{
	private int num;
	private int age;
	private String gender;
	
	public Survey()
	{
		
	}
	
	public Survey(int num, int age, String gender)
	{
		this.num = num;
		this.age = age;
		this.gender = gender;
	}
	
	public int getNum()
	{
		return num;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	@Override
	public String toString()
	{
		return "설문자 [번호 = " + num + ", 나이 = " + age + ", 성별 = " + gender + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
