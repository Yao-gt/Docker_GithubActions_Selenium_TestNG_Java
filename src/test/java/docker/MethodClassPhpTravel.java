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

	static String loginButton_xpath = "//div[@class='flex items-center gap-2']/a[contains(.,'Login')]";
	static String ingresoCorreo_xpath = "//div[@class='input-group']//input[@name='email']";
	static String ingresoContrasena_xpath = "//div[@class='input-group']//input[@name='password']";
	static String botonIniciarSesion_xpath = "//button[@class='btn w-full']";
	static String welcomeBack_xpath = "//div[@class='flex items-center gap-4']//h1[contains(.,'Dashboard')]";
	
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
