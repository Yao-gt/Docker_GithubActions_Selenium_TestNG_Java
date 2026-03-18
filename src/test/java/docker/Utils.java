package docker;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.qameta.allure.Allure;


public class Utils {

	 public static void captureScreenshot(RemoteWebDriver driver) throws IOException{
		  try {
			  TakesScreenshot ts = (TakesScreenshot)driver;
			  
			  Calendar currentDate = Calendar.getInstance();
	          SimpleDateFormat formatter = new SimpleDateFormat(
	                  "yyyy/MMM/dd HH:mm:ss");
	          String dateN = formatter.format(currentDate.getTime()).replace("/","_");
	          dateN = dateN.replaceAll(":", "-");
	          String title = driver.getTitle();
	          title	= title.replace("|", "-");  
	          String nameFile = "Screenshot_" + title + "_" + dateN;
	          
			  File file = ts.getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(file, new File("./screenshots/"+nameFile+".png")); 
	      } catch(IOException e) {
	    	  System.out.println("Failed to capture screenshot: " + e.getMessage());
	      }

	}
	 
	 public static void allureCaptureScreenshot(RemoteWebDriver driver) throws IOException{
			try {
				Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
