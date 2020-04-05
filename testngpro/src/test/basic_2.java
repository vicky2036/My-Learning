package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class basic_2 {
	@Parameters("URL")
	@Test
	public void run(String val) {
		System.out.println("yunner1");
		System.out.println(val);
	}
	@BeforeTest
	public void before() {
		System.out.println("I will run first");
	}
	@Test(groups={"Smoke"})
	public void run2() {
		System.out.println("yunner2");
	}

	@Test
	public void run3() {
		System.out.println("yunner3");
	}
	@Parameters("URL")
	@Test
	public void paravalue(String val) {
		System.out.println("yunner5");
		System.out.println(val);
	}
	@AfterSuite
	public void sunn(){
		System.out.println("HAHAHA I am Last");
	}

}
