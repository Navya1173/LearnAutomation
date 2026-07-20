package testUsingParameter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class paratest {
	
	@Test(dataProvider = "getdata")
	public void logintest(String username, String password) {
		System.out.println(username + "|" + password);
	}
	
	@DataProvider	
	public static Object[][] getdata(){
		Object[][] values = new Object[5][2];
		
		values[0][0] = "RDJ";
		values[0][1] = "tony";
		
		values[1][0] = "Emma Watson";
		values[1][1]="Bella";
		
		values[2][0] = "Tom";
		values[2][1]="*2 :)";
		
		return(values);
				
	}
}
