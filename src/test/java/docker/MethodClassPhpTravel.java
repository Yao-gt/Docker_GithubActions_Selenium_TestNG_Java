package docker;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodClassPhpTravel {
	
	RemoteWebDriver driver;
	WebDriverWait wait;
	
	public MethodClassPhpTravel(RemoteWebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10, 1));
	}

	static String loginButton_xpath = "//div[@class='header-right d-flex align-items-center justify-content-end']/a[contains(.,'Login')]";
	static String ingresoCorreo_xpath = "//div[@class='container']//input[@name='email']";
	static String ingresoContrasena_xpath = "//div[@class='container']//input[@name='password']";
	static String botonIniciarSesion_xpath = "//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']";
	static String welcomeBack_xpath = "//section[@class='dashboard-area']//h2[@class='sec__title font-size-30 text-white']";
	
	public void iniciarSesion(String correo, String contrasena) throws InterruptedException, IOException {
		try {
			WebElement elementLoginButton = driver.findElement(By.xpath(loginButton_xpath));
			elementLoginButton.click();
			
			boolean x = elementLoginButton.isDisplayed();
			if(x) {
				System.out.println("Login button clicked");	
			}else {
				System.out.println("Login button not clicked");	
			}
			
			Thread.sleep(15000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ingresoCorreo_xpath)));
			
			WebElement elementIngresoCorreo = driver.findElement(By.xpath(ingresoCorreo_xpath));
			elementIngresoCorreo.sendKeys(correo);
				
			WebElement elementIngresoContrasena = driver.findElement(By.xpath(ingresoContrasena_xpath));
			elementIngresoContrasena.sendKeys(contrasena);
			
			WebElement elementBotonIniciar = driver.findElement(By.xpath(botonIniciarSesion_xpath));
			elementBotonIniciar.click();
			
			Thread.sleep(5000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(welcomeBack_xpath)));
			
			Utils.captureScreenshot(driver);
			
			System.out.println("Login successful");	
		} catch (Exception e) {
			Utils.captureScreenshot(driver);
			e.printStackTrace();
		}			
	}
	
}
