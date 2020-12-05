package Org.qsp.Genric;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShot {
	public static void takeScreenS(WebDriver driver, String folder, String name) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Ss = ts.getScreenshotAs(OutputType.FILE);
		File ssSave = new File(folder + name + ".png");
		Files.copy(Ss, ssSave);
	}

}
