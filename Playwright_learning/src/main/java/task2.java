import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

public class task2 {

	public static void main(String[] args) throws InterruptedException {
		Playwright p = Playwright.create();
		Browser b= p.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//Launch the URL
		Page n = b.newPage();
		n.navigate("https://psautomation.mapsdevext.arcgis.com/apps/indoors/floorplaneditor.html?appid=887cf778df07456fb2952fe0d837da41");
		
		//sign in with sharing password
		n.locator("#j_username").fill("sharing");
		n.locator("#j_password").fill("MercatorRocks.25");
		n.locator("//input[@id =\"submit\"]").click();
		
		Thread.sleep(1000);
		
		//login with publisher password
		n.locator("#user_username").fill("publisher_psautomation");
		n.locator("#user_password").fill("indoorstest1");
		n.locator("#signIn").click();
		
		//SKIP MAIL VERIFICATION
		n.locator("button.js-skipBtn.flex.align-center.btn-transparent.font-size--3.pointer").click();
		
		//refresh if there's a blank app ID in URL
		n.navigate("https://psautomation.mapsdevext.arcgis.com/apps/indoors/floorplaneditor.html?appid=887cf778df07456fb2952fe0d837da41");
		
		//Create a full plan
		n.locator(".i-card").click(); //new plan
		Thread.sleep(500);
		n.locator("calcite-input-text").locator("input[aria-label='Title:']").fill("planName2"); //shadowroot
		n.locator("//calcite-button[@icon-end=\"caret-double-vertical\"]").click(); //indoors folder
		
		Thread.sleep(1000);
		
		List<Locator> list = n.locator("//calcite-dropdown-item").all();
		
		for(Locator item : list) {
			String t = item.innerText();
			if (t.equalsIgnoreCase("publisher_psautomation")) {
				item.click();
				break;
			}
		}
//		
		n.locator("//calcite-segmented-control-item").getByText("Organization").click(); //share
		n.locator("form.i--form calcite-button.i--blue").getByText("Next").click(); //next
		n.locator("//calcite-tile[@heading=\"Full plan\"]").click(); //full plan
		//n.keyboard().press("ArrowRight"); // type of plan - full plan
		
		n.locator("//form/calcite-panel/following-sibling::div/calcite-button").getByText("Create Plan").click();
//		
//		
//		//few minutes to load
//		
		Locator popout = n.locator("div.i-modal-working-content");
		popout.waitFor(new WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(1000000));
//		
		//Go back to main plan list
		
		
		//IF WE FIRST LOGOUT, HAVE TO LOGIN AGAIN TO DELETE ----- SO DELETE - 1ST THEN LOGOUT-------.
		
		//delete plan from portal
		n.navigate("https://psautomation.mapsdevext.arcgis.com");
		n.locator("#esri-header-menus-link-desktop-0-5").click();  //content
		
		
		Locator row = n.locator("arcgis-item-browser-table-row").filter(new Locator.FilterOptions().setHasText("planName2"));
		row.locator("calcite-checkbox.checkbox").click();
		
		
//		n.getByPlaceholder("Search All my content").fill("planName2");  //search by name
//		n.locator("calcite-checkbox.checkbox").click(); //select
		
		n.locator("calcite-button.button").getByText("Delete").click();
		
		n.locator("calcite-button.more-options__button").click(); //showmore in popup
		
		n.locator("calcite-button").getByText("Delete permanently (cannot be undone)").click(); //permanently delete option
		
		n.locator("calcite-button").getByText("Permanently delete").click(); //final delete
		
		

		//logout
		n.navigate("https://psautomation.mapsdevext.arcgis.com/apps/indoors/floorplaneditor.html?appid=887cf778df07456fb2952fe0d837da41");
		
		//time out
		//n.locator("div.i-miniapps-switcher-btn").click(); //menu
		//n.locator("calcite-button").getByText("Show all plans").click(); //show all plans
//		n.locator("//calcite-avatar[@username='publisher_psautomation']").click();
//		//n.locator("//calcite-action[@id=\"calcite-action-menu-28628da9-aa2e-7e5c-e929-749bcf544681-menu-button\"]").locator("#calcite-action-e4787a90-dca1-7516-db32-3d221ba2709e-button").click();    //profile
//		n.locator("button.button--text-visible ").click();    //sign out button
////		
		
		//checkbox
		//delete
		//popup - show more
		//click - delete permanently - link
		//click - delete permanently - button
	
		
	}

}
