package reportGenerate;


import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtendReportExample {

	WebDriver driver;
	ExtentReports extendReport;
	ExtentHtmlReporter htmlReporter;
	ExtentTest testCase;

	@Test
	public void OpenGoogle() throws IOException {
		testCase = extendReport.createTest("Verify Google Title");
		testCase.log(Status.INFO, "Navigation to Google");
		driver.get("https://www.google.co.in");
		String title = driver.getTitle();
		testCase.log(Status.INFO, "Actual Title : "+title);
		testCase.log(Status.INFO, "Expected Title : "+"Google");
		testCase.log(Status.INFO, "Verification of Actual and Expected Title ");
		if (title.equals("Google")) {
			testCase.log(Status.PASS, "Actual title and Expected title are equal");
		}else {
			testCase.log(Status.FAIL, "Actual title and Expected title are not equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("google.png");
			FileHandler.copy(sourceFile,destinationFile);
			testCase.addScreenCaptureFromPath("google.png");
		}

	}

	@Test
	public void OpenYoutube() throws IOException {
		testCase = extendReport.createTest("Verify Youtube Title");
		testCase.log(Status.INFO, "Navigation to Youtube");
		driver.get("https://www.youtube.com");
		String title = driver.getTitle();
		testCase.log(Status.INFO, "Actual Title : "+title);
		testCase.log(Status.INFO, "Expected Title : "+ "Youtube");
		testCase.log(Status.INFO, "Verification of Actual and Expected Title ");
		if (title.equals("Youtube")) {
			testCase.log(Status.PASS, "Actual title and Expected title are equal");
		}else {
			testCase.log(Status.FAIL, "Actual title and Expected title are not equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("youtube.png");
			FileHandler.copy(sourceFile,destinationFile);
			testCase.addScreenCaptureFromPath("youtube.png");
		}
	}

	@Test
	public void OpenGmail() throws IOException {
		testCase = extendReport.createTest("Verify Gmail Title");
		testCase.log(Status.INFO, "Navigation to Gmail");
		driver.get("https://mail.google.com");
		String title = driver.getTitle();
		testCase.log(Status.INFO, "Actual Title : "+title);
		testCase.log(Status.INFO, "Expected Title : "+"Gmail");
		testCase.log(Status.INFO, "Verification of Actual and Expected Title ");
		if (title.equals("Gmail")) {
			testCase.log(Status.PASS, "Actual title and Expected title are equal");
		}else {
			testCase.log(Status.FAIL, "Actual title and Expected title are not equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("gmail.png");
			FileHandler.copy(sourceFile,destinationFile);
			testCase.addScreenCaptureFromPath("gmail.png");
		}
	}

	@Test
	public void OpenBing() throws IOException {
		testCase = extendReport.createTest("Verify Bing Title");
		testCase.log(Status.INFO, "Navigation to Bing");
		driver.get("https://www.bing.com");
		String title = driver.getTitle();
		testCase.log(Status.INFO, "Actual Title : "+title);
		testCase.log(Status.INFO, "Expected Title : "+"Bing");
		testCase.log(Status.INFO, "Verification of Actual and Expected Title ");
		if (title.equals("bing")) {
			testCase.log(Status.PASS, "Actual title and Expected title are equal");
		}else {
			testCase.log(Status.FAIL, "Actual title and Expected title are not equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("bing.png");
			FileHandler.copy(sourceFile,destinationFile);
			testCase.addScreenCaptureFromPath("bing.png");
		}
	}

	@BeforeSuite
	public void LaunchBrowser() {
		extendReport = new ExtentReports(); 
		htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		extendReport.attachReporter(htmlReporter);
		driver = new ChromeDriver();

	}

	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
		extendReport.flush();
	}
}
