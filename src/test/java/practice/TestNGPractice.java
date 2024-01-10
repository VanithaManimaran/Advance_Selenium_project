package practice;

import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void createCustomer()
	{
		System.out.println("crate");
	}
	
	@Test(priority=-1,invocationCount=2)
	public void modifyCustomer()
	{
		System.out.println("modified");
	}
	
	@Test//(enabled=false)
	public void deleteCustomer()
	{
		System.out.println("deleted");
	}

}
