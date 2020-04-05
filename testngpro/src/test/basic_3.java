package test;

import org.testng.annotations.Test;

public class basic_3 {
	@Test(dependsOnMethods={"mike3"})
	public void mike() {
		System.out.println("hunner1");
	}
	@Test(enabled=false)
	public void mike2() {
		System.out.println("hunner2");
	}

	@Test(timeOut=4000)
	public void mike3() {
		System.out.println("hunner3");
	}

}
