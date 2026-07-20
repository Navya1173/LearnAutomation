package test_case;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GoBackOptions;
import com.microsoft.playwright.Page.GoForwardOptions;
import com.microsoft.playwright.Playwright;

public class launch_browser {

	public static void main(String[] args) throws InterruptedException {
		
		//obj
		max_2 two = new max_2 ();
		//two.max();
		two.browser_launch();
		
		
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		
		int width = ss.width;
		int h = ss.height;
		System.out.println(width + ", " + h);
		
		Playwright playwright = Playwright.create();
	    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    BrowserContext BC = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, h));
	    Page page = browser.newPage();
	    page.navigate("https://www.esri.com/en-us/digital-twin/overview");
	    System.out.println(page.title());
	    Thread.sleep(4000);
	    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("D:/esri1.png")));
	    page.close();
	    playwright.close();
	}  

	}
	
	class max_2{
		public static void max() throws InterruptedException {
		ArrayList <String> a = new ArrayList<>();
		a.add("--start-maximised");
		Playwright p = Playwright.create();
		Browser b = p.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setArgs(a));
		BrowserContext c = b.newContext(new Browser.NewContextOptions().setViewportSize(1280, 800));
		Page pp = b.newPage();
		pp.navigate("https://playwright.dev/java/docs/intro#whats-installed");
		System.out.println(pp.title());
		Thread.sleep(4000);
		pp.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("D:/max2.png")));
		pp.close();
		
		}
		
		public static void browser_launch() throws InterruptedException {
			Playwright edge = Playwright.create();
			Browser e = edge.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
			//BrowserContext bc = e.newContext(new Browser.NewContextOptions().setViewportSize(1280, 800));
			Page stc = e.newPage();
			stc.navigate("https://doc.esri.com/en/arcgis-pro/latest/tool-reference/space-time-pattern-mining/create-space-time-cube.html?tabs=dialog");
			//System.out.println(stc.title());
			stc.goForward(new GoForwardOptions().setTimeout(200));
			Thread.sleep(2000);
			stc.goBack(new GoBackOptions().setTimeout(200));
			Thread.sleep(2000);
			stc.reload();
			Thread.sleep(2000);
			stc.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("D:/stc.png")));
			stc.close();
			edge.close();
		}
	}


