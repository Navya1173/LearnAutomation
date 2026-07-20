import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

class tabs {
	public void tab() {
		Playwright a = Playwright.create();
		Browser c = a.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page d = c.newPage();
		d.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");
		Page popup = d.waitForPopup(()->{
		d.locator("text = Privacy Policy").nth(0).click();
		});
		d.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("D:/1.png")));
		popup.locator("//*[@id=\"header-sign-up-btn\"]").click();
		popup.locator("[id='name']").type("Navya Verma");
		popup.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("D:/name.png")));
		
		d.close();
		c.close();
		a.close();
		
	}
	
}

class hover{
	public void h6() {
		Playwright w = Playwright.create();
		Browser j = w.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
		Page y = j.newPage();
		y.navigate("https://www.way2automation.com/index.html");
		y.locator("//*[@id=\"navLinks\"]/a[1]").hover();
		y.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("D:/h1.png")));
		y.locator("//*[@id=\"navLinks\"]/div/a").hover();
		y.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("D:/h2.png")));
		y.locator("//*[@id=\"navLinks\"]/div/div/a[2]").click();
		
		y.close();
		j.close();
		w.close();
		
}

	
public class frames {

 public void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		hover k = new hover();
		k.h6();
//		
        tabs t = new tabs();
        t.tab();
//		
		Playwright p = Playwright.create();
		Browser b = p.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page n = b.newPage();
		n.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		n.frameLocator("[id ='iframeResult']").locator("body > button").click(new ClickOptions().setTimeout(2000));
		
		Locator f = n.locator("iframe");
		
		System.out.println(f.count());
		
		for(int i=0; i <f.count(); i++) {
			System.out.println(f.nth(i).getAttribute("id"));
		}

		n.close();
		b.close();
		p.close();
	}
}
}


