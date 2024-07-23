package Listeners1;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class ListenersNow {
    
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2");
		throw new SkipException("Test Skipped");
	}
	
	@Test
	public void test3() {
		System.out.println("Test 3");
		Assert.assertTrue(false);
	}
	
	
}
