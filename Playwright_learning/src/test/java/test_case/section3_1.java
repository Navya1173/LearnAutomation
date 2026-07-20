package test_case;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page.TypeOptions;

public class section3_1 {

	public static void main(String[] args) {
		Playwright s3 = Playwright.create();
		Browser google = s3.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page p = google.newPage();
		p.navigate("https://www.arcgis.com/index.html");
		p.click("text = Sign in");
		p.locator("#user_username").type("Navya_11");
		p.locator("#user_password").type("NavyaSky11");
		p.locator("#persistUser").check();
		p.locator("#persistUser").uncheck();
		p.click("button:has-text('Sign In')");
		//System.out.println(p.locator("@id=errMessage").innerText());
		//p.type("Id= user_usernam" , "Navya_11");
		//p.close();
		s3.close();
	}

}
