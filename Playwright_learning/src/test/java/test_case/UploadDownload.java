package test_case;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.ElementHandle.ScreenshotOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForDownloadOptions;
import com.microsoft.playwright.Playwright;

class download{
	public static void d() {
		Playwright play = 	Playwright.create();
		Browser br = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page pa = br.newPage();
		pa.navigate("https://isprs-annals.copernicus.org/articles/IV-5/109/2018/");
		pa.locator("//img[@alt =\"PDF\"]").click();
		pa.navigate("https://www.selenium.dev/downloads/");
		Download davy = pa.waitForDownload(()->{
			pa.locator("body > div > main > div.row.justify-content-center.px-5.pb-5 > div:nth-child(3) > div > div.card-body.px-0.text-center > p:nth-child(2) > a").click();
		});
		
		davy.saveAs(Paths.get(".src/test/resources/folderx/selenium-java-4.44.0.zip"));
		
		System.out.println("done with download");
		
		pa.close();
		br.close();
		play.close();
	}
}

class multiplefiles{
	public static void f() {
		Playwright a = 	Playwright.create();
		Browser d = a.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page s = d.newPage();
		s.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_multiple");
		s.frameLocator("#iframeResult").locator("#myFile").setInputFiles(new Path[] {
				Paths.get("./src/test/resources/folderx/vample.pdf"),
				Paths.get("./src/test/resources/folderx/sample.pdf")
		});
		s.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("D:/multiple.jpg")));
		System.out.println("uploaded successfully!");
		
		s.close();
		d.close();
		a.close();
	}
}

public class UploadDownload {
	
	public static void main(String[] args) {
		
		download g = new download();
		g.d();
		
		multiplefiles m = new  multiplefiles();
		m.f();
		
		Playwright P = 	Playwright.create();
		Browser b = P.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page x = b.newPage();
		x.navigate("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
		x.locator("#register_form > fieldset:nth-child(9) > input[type=file]").setInputFiles(Paths.get("./src/test/resources/folderx/vample.pdf"));
		x.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("D:/upload2.png")));
	    //x.locator("#register_form > fieldset:nth-child(9) > input[type=file]").setInputFiles(Paths.get("./src/test/resources/folderx/vample.pdf"));
		
		System.out.println("uploaded successfully!");
		x.close();
		b.close();
		P.close();

	}

}
