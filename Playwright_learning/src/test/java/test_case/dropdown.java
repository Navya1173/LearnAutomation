package test_case;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.options.SelectOption;


class slider{
	public static void sb() throws InterruptedException {
		Playwright t = Playwright.create();
		Browser g = t.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page z = g.newPage();
		z.navigate("https://jqueryui.com/resources/demos/slider/default.html");
		Thread.sleep(6000);
		Locator slide = z.locator("//*[@id=\"slider\"]");
		z.mouse().move(slide.boundingBox().x + slide.boundingBox().width/2, slide.boundingBox().y + slide.boundingBox().height/2);
		z.mouse().down();
		z.mouse().move(slide.boundingBox().x + 600, slide.boundingBox().y + slide.boundingBox().height/2);
		z.mouse().up();
		z.screenshot(new ScreenshotOptions().setPath(Paths.get("D:/slide.png")));
		
		z.close();
		g.close();
		t.close();
		
	}
}


class dragdrop{
	public static void dd() {
		Playwright play = Playwright.create();
		Browser bro = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page pa = bro.newPage();
		pa.navigate("https://jqueryui.com/resources/demos/droppable/default.html");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Locator drag = pa.locator("//div[@id =\"draggable\"]");
		pa.mouse().move(drag.boundingBox().x + drag.boundingBox().width/2, drag.boundingBox().y+ drag.boundingBox().height/2);
		pa.mouse().down();
		
		Locator drop = pa.locator("//div[@id =\"droppable\"]");
		pa.mouse().move(drop.boundingBox().x+drop.boundingBox().width/2, drop.boundingBox().y + drop.boundingBox().height/2);
		pa.mouse().up();
		
		pa.close();
		bro.close();
		play.close();
	}
}


public class dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		dragdrop dp = new dragdrop();
		dp.dd();
		
//		slider s6 = new slider();
//		s6.sb();
		
//		Playwright p = Playwright.create();
//		Browser b = p.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//		Page w = b.newPage();
//		w.navigate("https://www.wikipedia.org/");
//		//w.selectOption("select", "de"); //select by value
//		//w.selectOption("select", new SelectOption().setLabel("Hausa")); //by text or label
//		w.selectOption("select", new SelectOption().setIndex(26)); //by index[]
//		 
//	/*Locator total = w.locator("select > option");
//	System.out.println(total.count());
//		
//	for (int i =0;  i< total.count(); i ++) {
//		System.out.println(total.nth(i).innerText() + "  " + total.nth(i).getAttribute("lang"));
//	}*/
//	
//	List <ElementHandle> v = w.querySelectorAll("select > option");
//	System.out.println(v.size());
//	
//	for (ElementHandle ss : v) {
//		System.out.println(ss.innerText() + "  " + ss.getAttribute("lang"));
	//}
		//w.close();
		//p.close();

	}

}
