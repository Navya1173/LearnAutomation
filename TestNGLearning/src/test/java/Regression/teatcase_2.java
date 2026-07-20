package Regression;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class teatcase_2 {

		@BeforeTest
		public void db() {
			System.out.println("connecting to DB");
		}
		
		@AfterTest
		public void db2() {
			System.out.println("closing DB coonection");
		}
		
		@BeforeMethod
		public void browl() {
			System.out.println("launching msedge");
		}
		
		@AfterMethod
		public void browc() {
			System.out.println("clsoing it");
		}
		
		
		@Test(priority =2)
		public void login() {
			System.out.println("logged in");
			
		}

		@Test(priority =1)
		public void username() {
			System.out.println("username added-----------!");
	
		}
			
}
