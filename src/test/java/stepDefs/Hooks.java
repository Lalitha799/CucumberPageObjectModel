package stepDefs;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public static void setupDriver()
	{
		TestBase.initDriver();
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot screen=(TakesScreenshot) TestBase.getDriver();
			byte[] imgBytes=screen.getScreenshotAs(OutputType.BYTES);
			scenario.attach(imgBytes, "image/png", "ScreenImage");
		}
		TestBase.tearDown();
	}
}
