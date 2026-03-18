package docker;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

public class EdgeTest1 {

	@Epic("Edge")
	@Feature("This is Edge Test")
	@Description("Test for Edge")
	@Test(description = "PHPTravels Test", groups = "@smoke")
	public void test() throws InterruptedException, IOException {
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("disable-infobars");
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		
		URL url = new URL("http://localhost:4444/wd/hub");
		
		RemoteWebDriver driver = new RemoteWebDriver(url,options);

		driver.get("https://www.phptravels.net/");
		
		Thread.sleep(5000);

		driver.manage().window().fullscreen();
		
		Utils.captureScreenshot(driver);
		Utils.allureCaptureScreenshot(driver);
		
		System.out.println("Tittle of the page: " + driver.getTitle());
		System.out.println("Smoke Test");
		
		String correo = "user@phptravels.com";
		String contrasena = "demouser";
		
		MethodClassPhpTravel methodClassphp = new MethodClassPhpTravel(driver);
		methodClassphp.iniciarSesion(correo, contrasena);
		
		driver.quit();
		
	}
	
	@Epic("Edge")
	@Feature("This is a Failed Edge Test")
	@Description("Test for Edge")
	@Test(description = "Failed PHPTravels Test", groups = "@smoke")
	public void test2() throws InterruptedException, IOException {
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("disable-infobars");
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		
		URL url = new URL("http://localhost:4444/wd/hub");
		
		RemoteWebDriver driver = new RemoteWebDriver(url,options);

		driver.get("https://www.phptravels.net/");
		
		Thread.sleep(5000);

		driver.manage().window().fullscreen();
		
		Utils.captureScreenshot(driver);
		Utils.allureCaptureScreenshot(driver);
		
		System.out.println("Tittle of the page: " + driver.getTitle());
		System.out.println("Smoke Test");
		
		String correo = "user@phptravels.com";
		String contrasena = "demouserfailed";
		
		MethodClassPhpTravel methodClassphp = new MethodClassPhpTravel(driver);
		methodClassphp.iniciarSesion(correo, contrasena);
		
		driver.quit();
		
	}
	
	@Epic("Edge")
	@Feature("This is Edge Test")
	@Description("Test for Edge")
	@Test(description = "PHPTravels Test", groups = "@regresion")
	public void test3() throws InterruptedException, IOException {
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("disable-infobars");
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		
		URL url = new URL("http://localhost:4444/wd/hub");
		
		RemoteWebDriver driver = new RemoteWebDriver(url,options);

		driver.get("https://www.phptravels.net/");
		
		Thread.sleep(5000);

		driver.manage().window().fullscreen();
		
		Utils.captureScreenshot(driver);
		Utils.allureCaptureScreenshot(driver);
		
		System.out.println("Tittle of the page: " + driver.getTitle());
		System.out.println("Regresion Test");
		
		String correo = "user@phptravels.com";
		String contrasena = "demouser";
		
		MethodClassPhpTravel methodClassphp = new MethodClassPhpTravel(driver);
		methodClassphp.iniciarSesion(correo, contrasena);
		
		driver.quit();
		
	}
	
}
