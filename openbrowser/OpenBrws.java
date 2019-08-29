package openbrowser;

import java.util.Scanner;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


// open browser app//
public class OpenBrws {

	static WebDriver driver;
	static Wait<WebDriver> wait;
	static String fullPath, fullPath2;

	public static WebDriver startBrowser(String browserName, String url) {

		if (browserName.equalsIgnoreCase("firefox")) {

			try {
				Scanner scn = new Scanner(System.in);
				System.out.println(
						"Please enter full path for your browser driver(.exe included).Then press Enter after that ");
				fullPath = scn.nextLine();
				scn.close();
				if (fullPath.contains("\\")) {
					fullPath = fullPath.replace("\\", "\\\\");

				}
				System.setProperty("webdriver.firefox.marionette", fullPath);

				DesiredCapabilities desCap = DesiredCapabilities.firefox();
				driver = new FirefoxDriver(desCap);
				driver.manage().window().maximize();
				wait = new FluentWait<WebDriver>(driver)
						.withTimeout(10, TimeUnit.SECONDS)
						.pollingEvery(1, TimeUnit.SECONDS)
						.ignoring(java.util.NoSuchElementException.class);
				driver.manage().deleteAllCookies();
				driver.get(url);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (browserName.equalsIgnoreCase("chrome")) {
			try {
				Scanner scn = new Scanner(System.in);
				System.out.println(
						"Please enter full path for your browser driver(.exe included).Then press Enter after that");
				fullPath = scn.nextLine();
				scn.close();
				if (fullPath.contains("\\")) {
					fullPath = fullPath.replace("\\", "\\\\");

					System.setProperty("webdriver.chrome.driver", fullPath);
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					wait = new FluentWait<WebDriver>(driver)
							.withTimeout(10, TimeUnit.SECONDS)
							.pollingEvery(1, TimeUnit.SECONDS)
							.ignoring(java.util.NoSuchElementException.class);
					driver.manage().deleteAllCookies();
					driver.get(url);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (browserName.equalsIgnoreCase("ie")) {
			try {
				Scanner scn = new Scanner(System.in);
				System.out.println(
						"Please enter full path for your browser driver(.exe included).Then press Enter after that");
				fullPath = scn.nextLine();
				if (fullPath.contains("\\")) {
					fullPath = fullPath.replace("\\", "\\\\");
					scn.close();

					System.setProperty("webdriver.edge.driver", fullPath);
					driver = new EdgeDriver();
					driver.manage().window().maximize();
					wait = new FluentWait<WebDriver>(driver)
							.withTimeout(10, TimeUnit.SECONDS)
							.pollingEvery(1, TimeUnit.SECONDS)
							.ignoring(java.util.NoSuchElementException.class);
					driver.manage().deleteAllCookies();
					driver.get(url);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}

	static public void closeBrowser() {
		try {
			Thread.sleep(2000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
