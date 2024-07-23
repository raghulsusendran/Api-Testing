package Listeners1;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class ListenersNow2 {
    
	@Test
	public void test4() {
		System.out.println("Test 4");
	}
	
	@Test
	public void test5() {
		System.out.println("Test 5");
		throw new SkipException("Test Skipped");
	}
	
	@Test
	public void test6() {
		System.out.println("Test 6");
		Assert.assertTrue(false);
	}
	
	
}
