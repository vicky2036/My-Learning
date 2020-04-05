package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class basic_dataprovider {

	@Test(dataProvider="getData")
	public void datasetter(String uname,String upwd) {
		System.out.println("timee data :");
		System.out.println("UName:"+uname+" UPwd:"+upwd);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		// 1st set
		data[0][0] = "FirstUser";
		data[0][1] = "FIrstPwd";
		// 2st set
		data[1][0] = "SecondUser";
		data[1][1] = "SecondPwd";
		// 1st set
		data[2][0] = "ThirdUser";
		data[2][1] = "ThirdPwd";
		
		return data;
	}
}
