import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Locator.FilterOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class indoors {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Playwright a = Playwright.create();
		Browser b = a.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
		BrowserContext c = b.newContext(new Browser.NewContextOptions().setViewportSize(1920,1200));
		Page p = c.newPage();
		p.navigate("https://psautomation.mapsdevext.arcgis.com/home/dlogin.html?returnUrl=https://psautomation.mapsdevext.arcgis.com/apps/spaceplanner/index.html?appid=f3ca9d224bf54e769eb13d9b2b194ee2");
		
		//SHIELD PAGE
		p.locator("#j_username").fill("sharing");
		p.locator("#j_password").fill("MercatorRocks.25");
		p.locator("#submit").click();
		
		//AGOL page
		p.locator("#user_username").fill("publisher_psautomation");
		p.locator("#user_password").fill("indoorstest1");
		p.locator("#signIn").click();
		p.locator("//button[@class =\"js-skipBtn flex align-center btn-transparent font-size--3 pointer\"]").click();
		
		p.navigate("https://psautomation.mapsdevext.arcgis.com/apps/spaceplanner/index.html?appid=f3ca9d224bf54e769eb13d9b2b194ee2");
		
		//CREATING A NEW PLAN
		p.getByText("New Plan").click();
		p.locator("#id-0-title").fill("test_plan6");
		p.locator("#id-0-summary").fill("Testing this Indoor Space Planner. #redlines #esriHQ");
		p.getByText("Organization").click();
		p.getByText("Create Plan").click();
		
		//ASSIGN THE NEW PLAN
		Thread.sleep(95000);
		p.locator("//aside//button[@title=\"People\"]").click();
		p.getByPlaceholder("Search people by name...").fill("Javier");
		p.locator("//div[@role=\"listitem\"]").hover();
		p.locator("//button[@data-tip=\"Workspace Area\"]").click();
		
		//Page popup2 = p2.waitForClose(()->{
		p.getByPlaceholder("Search areas by name...").fill("Indoors Hotel");
		p.locator("//div[@role=\"listitem\"]").filter(new FilterOptions().setHasText("Indoors Hotel")).click();
		p.locator("//button[ text()=\"Assign\"]").click();
		//});
		
		//Page popup3 = p2.waitForClose(()->{
		p.locator("//button[ text()=\"Assign\"]").click();
		//});
		
		//UNASSIGN
			//Thread.sleep(45000);
		//p.locator("//aside//button[@title=\"Workspace Areas\"]").click();
		p.locator("//button[@title=\"Workspace Areas\"]").click();
		List<Locator> list = p.locator("//div[@role='listitem']//h4/div").all();
		
		
		for (int i = 0; i < list.size(); i++) {
			String title = list.get(i).innerText();
			
			if (title.equalsIgnoreCase("Indoors Hotel")) {
				list.get(i).click();
				break;
			}
		}
		
		List<Locator> list2 = p.locator("//div[@role=\"listitem\"]/div/div").all();
		for(int s =0; s<list2.size(); s++) {
			String n = list2.get(s).innerText();
			if (n.equalsIgnoreCase("Javier Leija")) {
				Thread.sleep(2000);
				list2.get(s).locator("//button[@title='Unassign']").click();
				break; }
		}
		Thread.sleep(2000);
		p.locator("button.i-ok-button").click();
		
		//p.locator("//*[@id=\"root\"]/div[2]/div[1]/div/div[1]/div[1]/div/div/div[2]/div[4]/div/div/div/div/div/h4").click();
		//p.locator("//*[@id=\"root\"]/div[2]/div[1]/div/div[1]/div[1]/div/div/div[2]/div/div/div[3]/div/article/div/div[1]/div/div/div[3]/div/div/div/div/button").click();
	
		System.out.println("Task completed!");
	
	}
	
	}

