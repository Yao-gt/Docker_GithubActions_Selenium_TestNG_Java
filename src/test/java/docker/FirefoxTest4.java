package docker;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

public class FirefoxTest4 {

	@Epic("Firefox")
	@Feature("This is Firefox Test")
	@Description("Test for Firefox")
	@Test(description = "PHPTravels Test")
	public void test() throws InterruptedException, IOException {
		
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("disable-infobars");
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		
		URL url = new URL("http://localhost:4444/wd/hub");
		
		RemoteWebDriver driver = new RemoteWebDriver(url,options);

		driver.get("https://www.phptravels.net/");
		
		Thread.sleep(5000);
		
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
