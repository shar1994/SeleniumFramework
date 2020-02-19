package qa.automation.core;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest event;

	@BeforeTest
	public void Pre_report() {
		// start reporters
		htmlReporter = new ExtentHtmlReporter("./Extent-Report/extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it
		event = extent.createTest("MyFirstTest", "Sample description");
	}

	@Test
	public void extentreport() throws Exception {

		// log(Status, details)
		event.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		event.info("This step shows usage of info(details)");

		// log with snapshot
		event.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		event.addScreenCaptureFromPath("screenshot.png");

	}

	@AfterTest
	public void exit_report() {
		// calling flush writes everything to the log file
		extent.flush();
	}

}