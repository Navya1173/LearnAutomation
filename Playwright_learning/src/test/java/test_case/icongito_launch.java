package test_case;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class icongito_launch {

	public static void main(String[] args) {
		Playwright p = Playwright.create();
		Browser b = p.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bc = p.chromium().launchPersistentContext(Paths.get(" "), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
		Page n = bc.newPage();
		n.navigate("https://mvnrepository.com/artifact/com.microsoft.playwright/playwright/1.60.0");
		System.out.println(n.title());
		//Thread.sleep(5000);
		n.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("D:/j.png")));
		n.close();
		p.close();
	}

}
