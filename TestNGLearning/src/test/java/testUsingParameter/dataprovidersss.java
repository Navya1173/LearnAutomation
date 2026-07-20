package testUsingParameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovidersss {
	
	@Test(dataProvider = "dp1")
	public static void test(String username, String password) {	
		System.out.println(username + "|"+ password);
	}
	
	@DataProvider(name="dp1")
	public static Object[][] getdata() {
		Object[][] d1 = new Object[2][2];
		
		d1[0][0] ="balance";
		d1[0][1] = "yu21";
		
		d1[1][0] ="UB-150";
		d1[1][1]="uni";
		
		return d1;
		
	}

}
