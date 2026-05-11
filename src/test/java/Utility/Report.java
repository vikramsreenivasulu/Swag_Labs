package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

	public static  ExtentTest node;
	public static void startReport() {

		extentSparkReporter = new ExtentSparkReporter(
				"C:\\Users\\vikram.sreenivasulu\\eclipse-workspace\\swag_labs\\Reports\\htmlReport.html");
		extentSparkReporter.config().setDocumentTitle("Swag Labs Automation Report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setReportName("SwagLabs");
		extentSparkReporter.config().setEncoding("utf-8");
		
		extentSparkReporter.config().setCss(

				/* ===== GLOBAL FONT & CLEAN UI ===== */
				  "body { font-family: 'Segoe UI', sans-serif;" +

				/* ===== TEST BLOCK (LEFT PANEL) ===== */
				".test-item.pass { background: linear-gradient(90deg, #1f4037, #99f2c9) !important; color:black !important; border-radius:10px; }" +

				/* ===== NODE (Login Page / Login Issue) ===== */
				".card { border-radius:12px !important; overflow:hidden; margin-bottom:15px; }" +
				".card-header { border-radius:12px !important; }" +

				/* ===== PASS NODE GREEN ===== */
				".card-header:has(.pass-bg) { background: linear-gradient(90deg, #a8edea, #d4fc79) !important; color:black !important; }" +

				/* ===== FAIL NODE RED ===== */
				".card-header:has(.fail-bg) { background: #f8a5a5  !important; color:black !important; }" +
				
				/* ===== LOG ROWS ===== */
				".event-row:hover { background-color: rgba(255,255,255,0.05); }" +

				/* ===== BADGES ===== */
				".pass-bg { background-color: #28a745 !important; }" +
				".fail-bg { background-color: #dc3545 !important; }" +
				".info-bg { background-color: #17a2b8 !important; }" +
				".badge, .badge-default, .badge-primary { color: black !important; }" +
				".badge { color: black !important; border:1px solid #333 !important; }" +
				
				/* ===== SCREENSHOT BORDER ===== */
				"img { border-radius:8px; border:1px solid #444; }"


				);
		  
		
		extentReports= new ExtentReports();
		extentReports.setSystemInfo("Name", "Vikram");
		extentReports.setSystemInfo("Team", "Automation Team");
		extentReports.setSystemInfo("System", "CPLBNGLPT103");
		extentReports.attachReporter(extentSparkReporter);

	}
	
	
	public static void createTest(String testName) {
		 extentTest = extentReports.createTest(testName);

	}
	
	
	 public static void createNode(String testName) {
		 node = extentTest.createNode(testName);
		 }

	public static void pass(String testName) {
		node.pass(testName);

	}
	
	public static void fail(String testName) {
		node.fail(testName);
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		String fileName =  "failed"+ "_" + timeStamp;
		String screenshotPath = caputreScreenshot(fileName);

		node.fail("Failed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	}
	
	public static void flush() {
		extentReports.flush();

	}
	
	public static void logInfo(String info) {
		node.info(info);

		
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		String fileName = info + "_" + timeStamp;
		String screenshotPath = caputreScreenshot(fileName);

		node.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}
	
	public static String caputreScreenshot(String fileName) {
	    TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
	    File srcFile = ts.getScreenshotAs(OutputType.FILE);

	    String projectRoot = System.getProperty("user.dir");
	    
	    // Save screenshot relative to Reports folder
	    String relativePath = ".." + File.separator + "Screenshots" + File.separator + fileName + ".png";
	    String absolutePath = projectRoot + File.separator + "Screenshots" + File.separator + fileName + ".png";

	    File dest = new File(absolutePath);
	    dest.getParentFile().mkdirs();

	    try {
	        FileUtils.copyFile(srcFile, dest);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return relativePath; // Return relative path for HTML
	}//caputreScreenshot
	
//	 public static void getResult(ITestResult testResult) {
//
//		    int status = testResult.getStatus();
//
//		    if (status == ITestResult.FAILURE) {
//
//		        String message = testResult.getThrowable().getMessage();
//		        String[] lines = message.split("\\r?\\n");
//
//		        boolean isAssertFailure =
//		                lines.length > 1 && lines[0].startsWith("The following asserts failed:");
//
//		        if (isAssertFailure) {
//
//		        	extentTest.log(Status.FAIL,
//		                    MarkupHelper.createLabel(message, ExtentColor.RED));
//
//		        	extentTest.fail(MarkupHelper.createCodeBlock(ExceptionUtils.getStackTrace(testResult.getThrowable())));
//
//		        } else {
//
//					String errorMsg = lines[0].trim();
//		
//					System.out.println("Error Message : " + errorMsg);
//
//
//					extentTest.log(Status.FAIL,
//		                    MarkupHelper.createLabel(errorMsg, ExtentColor.RED));
//
//					extentTest.fail(MarkupHelper.createCodeBlock(ExceptionUtils.getStackTrace(testResult.getThrowable())));
//
//		            // 2️⃣ FAILURE SCREENSHOT (getScreenShot() MUST return RELATIVE path)
//		            String relativeScreenshotPath =
//		                    caputreScreenshot(testResult.getName());
//
//		            // 3️⃣ ADD TO EXTENT
//		            extentTest.addScreenCaptureFromPath(relativeScreenshotPath);
//		        }
//
//			} else if (status == ITestResult.SKIP) {
//
//				String methodName = testResult.getMethod().getMethodName();
//
//				extentTest.log(Status.SKIP,
//						MarkupHelper.createLabel(
//								"<b>" + methodName + "----> SKIPPED" + "+_____________________+Ran on node--->" + methodName,
//								ExtentColor.ORANGE));
//
//				extentTest.skip(testResult.getThrowable());
//
//			} else if (status == ITestResult.SUCCESS) {
//
//				String methodName = testResult.getMethod().getMethodName();
//
//				extentTest.log(Status.PASS,
//						MarkupHelper.createLabel(
//								"<b>" + methodName + "----> PASSED" + "+_____________________+Ran on node--->" + methodName,
//								ExtentColor.GREEN));
//			}
//		    
//	 }


	

}
