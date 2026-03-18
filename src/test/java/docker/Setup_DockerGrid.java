package docker;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Setup_DockerGrid {

	@BeforeTest
	void startDockerGrid() throws InterruptedException, IOException {
		Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
		Thread.sleep(120000);
	}
	
	@AfterTest
	void stopDockerGrid() throws InterruptedException, IOException {
		Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
		Thread.sleep(10000);
		
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	}
	
}
