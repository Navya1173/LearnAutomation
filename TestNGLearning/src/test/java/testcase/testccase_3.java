package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class testccase_3 {
	
	 SoftAssert sa = new SoftAssert();
	 
	public void asserthat() {
		String etitle = "overloading";
		String atitle = "polymorphesim";
		
		if (etitle.equalsIgnoreCase(atitle)) {
			System.out.println("accepted!");
		}
		else {
				System.out.println("failed test");
			}
		
		//Assert.assertEquals(etitle, atitle);
		
		sa.assertTrue(true, "error");
		
		//Assert.fail(atitle);
		
		System.out.println("addition test");
		int a = 4; 
		int b = 12;
		int c = 16;
		int x = a+b;
		
		
		sa.assertEquals(c, x);
		
		//sa.assertEquals(c, x);
		
		sa.assertEquals(a, b);
		
		sa.assertAll();
		
		}
}
