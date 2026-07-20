package testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testcase_1 {
	
//	@BeforeTest
//	public void db() {
//		System.out.println("connecting to DB");
//	}
//	
//	@AfterTest
//	public void db2() {
//		System.out.println("closing DB coonection");
//	}
//	
//	@BeforeMethod
//	public void browl() {
//		System.out.println("launching msedge");
//	}
//	
//	@AfterMethod
//	public void browc() {
//		System.out.println("clsoing it");
//	}
	
	//test cases/////
	
	@Test(priority =2)
	public void login() {
		System.out.println("logged in");
		
	}

	@Test(priority =1)
	public void username() {
		System.out.println("username added-----------!");
	AssertJUnit.fail();
	}
		
	@Test(priority =3)
	public void password() {
		System.out.println(".............");	
	}
	
	@Test(priority =4, dependsOnMethods = "username", alwaysRun = true)
	public void submit() {
		System.out.println(".clicked");
					
	}
}
