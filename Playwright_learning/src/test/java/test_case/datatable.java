package test_case;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


class shadowDOM{
	public static void elem() throws InterruptedException {
		Playwright a = Playwright.create();
		Browser c = a.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
		Page w = c.newPage();
		w.navigate("edge://downloads/");
		w.locator("#control").type("navya");
		Thread.sleep(5000);
		w.close();
		c.close();
		a.close();
	}
	}

public class datatable {

	public static void main(String[] args) throws InterruptedException {
		
		shadowDOM sd = new shadowDOM();
			sd.elem();
		
		
		
		Playwright p = Playwright.create();
		Browser b = p.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page n = b.newPage();
		n.navigate("https://www.w3schools.com/html/html_tables.asp");
		n.locator("//table[@id =\"customers\"]").allInnerTexts().forEach(text-> System.out.println(text));
		System.out.println(n.locator("//table[@id =\"customers\"] //tr").count());
		System.out.println(n.locator("//table[@id =\"customers\"]").locator("//tr").count());
		
		assertThat(n.locator(" //table[@id =\"customers\"]//tr/th[2]")).hasText("Contact");
		
		n.close();
		b.close();
		p.close();

	}

}
