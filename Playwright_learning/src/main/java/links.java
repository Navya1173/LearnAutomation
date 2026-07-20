import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class links {

	public static void main(String[] args) {
		
		checkboxes aa = new checkboxes();
		try {
			aa.c_test();
		} catch (InterruptedException e) {
			// TOD
		
		System.out.println(links.count());
		
		//for(int x = 0; x<links.counO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Playwright l = Playwright.create();
		Browser b = l.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page p = b.newPage();
		p.navigate("https://www.wikipedia.org");
		Locator n = p.locator("a");
		System.out.println("total links = " + n.count());
		
		for(int i = 0; i <n.count(); i++) {
			System.out.println(n.nth(i).innerText() + "  " + n.nth(i).getAttribute("href"));
		}

		Locator last = p.locator("//*[@id=\"www-wikipedia-org\"]/footer/nav") ;
		Locator links = last.locator("a");t(); x++ ) {
			System.out.println(links.nth(2).innerText() +   " -> " + links.nth(2).getAttribute("href"));	
		//}
		links.nth(2).click();
		
	}

}


class checkboxes{
	public static void c_test() throws InterruptedException {
		
		Playwright pl = Playwright.create();
		Browser cb = pl.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page c = cb.newPage();
		c.navigate("file:///C:/Users/navya.verma/Downloads/checkdabhe.html");
		
		Locator boxes = c.locator("[type = 'checkbox']");
		for(int l=0; l<boxes.count(); l++) {
			boxes.nth(l).click();
		}
		
		Locator av = c.locator("#navya");
		av.click();
		
		Thread.sleep(4000);
		
		System.out.println(boxes.count());
		
		c.close();
		cb.close();
		pl.close();
		
	}
}