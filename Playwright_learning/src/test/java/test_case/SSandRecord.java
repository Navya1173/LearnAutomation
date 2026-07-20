package test_case;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;


class recordss{
	public static void r() {
		Playwright z = Playwright.create();
		Browser y  = z.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext l = y.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"))) ;
		Page o = l.newPage();
		o.navigate("https://isprs-annals.copernicus.org/articles/IV-5/109/2018/");
		o.locator("//img[@alt =\"PDF\"]");
		o.navigate("https://www.selenium.dev/downloads/");
		o.close();
		l.close();
		z.close();
	}
}

class trace{
	public static void viewer() {
		Playwright play = Playwright.create();
		Browser hi = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext cx = hi.newContext();
		
		cx.tracing().start(new Tracing.StartOptions()
				  .setScreenshots(true)
				  .setSnapshots(true)
				  .setSources(true));
		
		Page pe = cx.newPage();
		pe.navigate("https://www.arcgis.com/index.html");
		pe.locator("//button[text()= \"Sign In\"]").click();
		//pe.locator("button: has-text('Sign in')").click();
		pe.locator("#user_username").fill("navya");
		pe.locator("#user_password").fill("10000000000");
		
		cx.tracing().stop(new Tracing.StopOptions()
				  .setPath(Paths.get("trace.zip")));
		
		pe.close();
		cx.close();
		play.close();
			
	}
}



public class SSandRecord {

	public static void main(String[] args) {
		
		trace vie = new trace();
		vie.viewer();
		
//		recordss tt = new recordss();
//		tt.r();
		
//		Playwright p = Playwright.create();
//		Browser b = p.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//		Page n = b.newPage();
//		n.navigate("https://isprs-annals.copernicus.org/articles/IV-5/109/2018/");
//		Locator wa = n.locator("//img[@alt =\"PDF\"]");
//		wa.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(".records/ss.png")));
//		System.out.println("element captured");
//		wa.click();
//		n.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(".records/ss2.png")));
//		n.close();
//		b.close();
//		p.close();		
	}

}
