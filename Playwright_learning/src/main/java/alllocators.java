import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Response;



public class alllocators {

	public static void main(String[] args) {
		Playwright p = Playwright.create();
		Browser b= p.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//Launch the URL
		Page n = b.newPage();
		n.navigate("https://psautomation.mapsdevext.arcgis.com/apps/indoors/floorplaneditor.html?appid=887cf778df07456fb2952fe0d837da41");

	}
	
	class  login{
		public static void log1() {
			
			Locator user = n.locator("#j_username");	
			user.fill("sharing");
		}
		
	}
	
}
