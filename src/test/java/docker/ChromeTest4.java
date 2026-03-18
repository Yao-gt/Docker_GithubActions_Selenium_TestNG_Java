package docker;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

public class ChromeTest4 {

	@Epic("Chrome")
	@Feature("This is Chrome Test")
	@Description("Test for Chrome")
	@Test(description = "PHPTravels Test")
	public void test() throws InterruptedException, IOException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		
		URL url = new URL("http://localhost:4444/wd/hub");
		
		RemoteWebDriver driver = new RemoteWebDriver(url,options);

		driver.get("https://www.phptravels.net/");
		
		Thread.sleep(10000);
		
		Utils.captureScreenshot(driver);
		Utils.allureCaptureScreenshot(driver);
		
		System.out.println("Tittle of the page: " + driver.getTitle());
		
		String correo = "user@phptravels.com";
		String contrasena = "demouser";
		
		MethodClassPhpTravel methodClassphp = new MethodClassPhpTravel(driver);
		methodClassphp.iniciarSesion(correo, contrasena);
		
		driver.quit();
		
	}

	

}
