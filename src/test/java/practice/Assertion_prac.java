package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_prac {
	
	@Test
	public void sample()
	{
		System.out.println("step1");
		System.out.println("step2");
		
		Assert.assertEquals(true, false);
		
		System.out.println("step3");
		System.out.println("step4");

	}
	
	@Test
	public void sample1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("step1");
		System.out.println("step2");
		
		sa.assertEquals(true, false);
		
		System.out.println("step3");
		
		sa.assertEquals(0, 1);
		System.out.println("step4");
		
		sa.assertAll();

	}
	

}
