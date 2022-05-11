package survey;

public class Survey02 
{
	private int num;
	private int first;
	private int second;
	private int third;
	
	public Survey02  () {}
	
	public Survey02(int first, int second, int third)
	{
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public Survey02(int num, int first, int second, int third)
	{
		this.num = num;
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public int getFirst() 
	{	
		return first;
	}
	
	public void setFirst(int first)
	{
		this.first = first;
	}
	
	public int getSecond()
	{
		return second;
	}
	
	public void setSecond(int second)
	{
		this.second = second;
	}
	
	public int getThird()
	{
		return third;
	}
	
	public void setThird(int third)
	{
		this.third = third;
	}
	
	@Override
	public String toString()
	{
		return "[first + second + third]"; // ¸Â³ª?
	}
	
	
	
}
