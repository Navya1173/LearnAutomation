import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Assertions {

	public static void main(String[] args) {
		Playwright p = Playwright.create();
		Browser b = p.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page n = b.newPage();
		n.navigate("https://isprs-annals.copernicus.org/articles/IV-5/109/2018/");
		assertThat(n).hasURL("https://isprs-annals.copernicus.org/articles/IV-5/109/2018/");
		assertThat(n).hasTitle("ISPRS-Annals - AN OPEN SOURCE WEB-GIS BASED PRECISE SATELLITE TRACKING AND VISUALISATION TOOL USING TWO LINE ELEMENT DATA");
		assertThat(n.locator("#mega-menu-label-4")).hasText("Open Resources");
		
		n.close();
		b.close();
		p.close();
	
	}

}
