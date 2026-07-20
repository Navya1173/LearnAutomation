package testcase;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class skiptest {
	
	@Test
	public void skipyskip() {
		
		throw new SkipException("here comes the message in String that is in double inverted commas");
		
	}

}
