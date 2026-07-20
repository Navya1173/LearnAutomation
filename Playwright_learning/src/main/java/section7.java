import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.TypeOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;



class keyboard{
	
	public static void kk() throws InterruptedException {
		Playwright pp = Playwright.create();
		Browser bb = pp.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page q = bb.newPage();
		q.navigate("https://in.search.yahoo.com/?fr2=inr");
		
		q.getByPlaceholder("Search the web").type("Space Debris");
		Thread.sleep(1000);
		q.keyboard().press("Enter");
		Thread.sleep(1000);
		
		q.goBack();
		
		q.locator("#yschsp").type("bioinvasion of plant species", new TypeOptions().setDelay(100));
		q.keyboard().press("Control+A");
		q.keyboard().press("Control+x");
		Thread.sleep(1000);
		q.keyboard().press("Control+v");
		Thread.sleep(1000);
		
		q.keyboard().down("Shift");
		
	for (int i = 0; i<7; i++) {
		q.keyboard().press("ArrowLeft");
		Thread.sleep(1000);
	}
	
	q.close();
	bb.close();
	pp.close();
	
	}
}



public class section7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		keyboard k = new keyboard();
		k.kk();
		
//		Playwright p = Playwright.create();
//		Browser b = p.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//		Page n = b.newPage();
//		n.navigate("http://google.com");
//		System.out.println(n.evaluate("document.location.href"));
//		
//		n.evaluate("() => {"
//				+ "const textarea = document.createElement('textarea');"
//				+ "document.body.append(textarea);"
//				+ "textarea.focus();"
//				+"}");
//		
//		String text = "Hello World !!";
//		n.keyboard().type(text);
//		
//		n.clock();
//		b.close();
//		p.close();
		
		
//		n.evaluate("()=> {"
//				+ "const textarea = documemt.createElement('textarea');" 
//				+ "document.body.append(textarea);"
//				+ "textarea.focus();"
//				+"}");
//		
//		n.keyboard().type("sandwich");

	}

}
