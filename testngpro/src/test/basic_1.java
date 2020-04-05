package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class basic_1 {
	
	@BeforeSuite
	public void sunn(){
		System.out.println("HAHAHA I am first");
	}
	@Test
	public void run(){
		System.out.println("Hello");
	}
	
	@Test(groups={"Smoke"})
	public void run2(){
		System.out.println("Hello2");
	}
	@AfterTest
	public void Last(){
		System.out.println("I am at last");
	}
	@BeforeMethod
	public void bfmeth(){
		System.out.println("I will before method");
	}

}
