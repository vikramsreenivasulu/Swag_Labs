package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Report {

	public static ExtentSparkReporter extentSparkReporter;
	
	public static ExtentReports extentReports;
	
	public static ExtentTest extentTest;

	public static void startReport() {

		extentSparkReporter = new ExtentSparkReporter(
				"C:\\Users\\vikram.sreenivasulu\\eclipse-workspace\\swag_labs\\Reports\\htmlReport.html");
		extentSparkReporter.config().setDocumentTitle("Swag Labs Automation Report");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentSparkReporter.config().setReportName("SwagLabs");
		extentSparkReporter.config().setEncoding("utf-8");
		
		
		extentReports= new ExtentReports();
		extentReports.setSystemInfo("Name", "Vikram");
		extentReports.setSystemInfo("Team", "Automation Team");
		extentReports.setSystemInfo("System", "CPLBNGLPT103");
		extentReports.attachReporter(extentSparkReporter);

	}
	
	
	public static void createTest(String testName) {
		 extentTest = extentReports.createTest(testName);

	}
	
	public static void pass(String testName) {
		extentTest.pass(testName);

	}
	
	public static void fail(String testName) {
		extentTest.fail(testName);

	}
	
	public static void flush() {
		extentReports.flush();

	}
	
	public static void logInfo(String info) {
		extentTest.info(info);
		
		String screenshotPath = caputreScreenshot(info);
		extentTest.pass("Screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}
	
	public static String caputreScreenshot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);

		String projectRoot = System.getProperty("user.dir");
		String filePath = projectRoot + File.separator + "Screenshots" + File.separator + fileName + ".png";

		File dest = new File(filePath);
		dest.getParentFile().mkdirs();

		try {
			FileUtils.copyFile(srcFile, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;

	}
	
	 public static void getResult(ITestResult testResult) {

		    int status = testResult.getStatus();

		    if (status == ITestResult.FAILURE) {

		        String message = testResult.getThrowable().getMessage();
		        String[] lines = message.split("\\r?\\n");

		        boolean isAssertFailure =
		                lines.length > 1 && lines[0].startsWith("The following asserts failed:");

		        if (isAssertFailure) {

		        	extentTest.log(Status.FAIL,
		                    MarkupHelper.createLabel(message, ExtentColor.RED));

		        	extentTest.fail(MarkupHelper.createCodeBlock(ExceptionUtils.getStackTrace(testResult.getThrowable())));

		        } else {

					String errorMsg = lines[0].trim();
		
					System.out.println("Error Message : " + errorMsg);


					extentTest.log(Status.FAIL,
		                    MarkupHelper.createLabel(errorMsg, ExtentColor.RED));

					extentTest.fail(MarkupHelper.createCodeBlock(ExceptionUtils.getStackTrace(testResult.getThrowable())));

		            // 2️⃣ FAILURE SCREENSHOT (getScreenShot() MUST return RELATIVE path)
		            String relativeScreenshotPath =
		                    caputreScreenshot(testResult.getName());

		            // 3️⃣ ADD TO EXTENT
		            extentTest.addScreenCaptureFromPath(relativeScreenshotPath);
		        }

			} else if (status == ITestResult.SKIP) {

				String methodName = testResult.getMethod().getMethodName();

				extentTest.log(Status.SKIP,
						MarkupHelper.createLabel(
								"<b>" + methodName + "----> SKIPPED" + "+_____________________+Ran on node--->" + methodName,
								ExtentColor.ORANGE));

				extentTest.skip(testResult.getThrowable());

			} else if (status == ITestResult.SUCCESS) {

				String methodName = testResult.getMethod().getMethodName();

				extentTest.log(Status.PASS,
						MarkupHelper.createLabel(
								"<b>" + methodName + "----> PASSED" + "+_____________________+Ran on node--->" + methodName,
								ExtentColor.GREEN));
			}
		    
	 }

}
