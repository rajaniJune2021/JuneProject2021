package commonUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportUtility {

    public static ExtentReports report;
    public static ExtentTest testReport;
    static Calendar cal = Calendar.getInstance();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
    public static String reportFile = System.getProperty("user.dir") + "/ExecutionReport/Reports/AutomationReport" + dateFormat.format(cal.getTime()) + ".html";

    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(fileName);
        report = new ExtentReports();
        report.attachReporter(reporter);

        return report;
    }

    public static String takeAScreenShot(String screenShotName) {
        String filePath = "";
        try {
            TakesScreenshot screenShot = (TakesScreenshot) DriverUtility.driver;
            File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
            filePath = System.getProperty("user.dir") + "/ExecutionReport/ScreenShots/" + screenShotName + ".png";
            File destFile = new File(filePath);
            FileUtils.copyFile(srcFile, destFile);
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    public static void passCase(String logger, String screenshotName) {
        try {
             //testReport.addScreenCaptureFromPath(takeAScreenShot(screenshotName));
            MediaEntityModelProvider media = MediaEntityBuilder.createScreenCaptureFromPath(takeAScreenShot(screenshotName)).build();
            testReport.pass(logger+testReport.addScreenCaptureFromPath(takeAScreenShot(screenshotName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void failCase(String logger, String screenshotName) {
        try {
            MediaEntityModelProvider media = MediaEntityBuilder.createScreenCaptureFromPath(takeAScreenShot(screenshotName)).build();
            testReport.fail(logger, media);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initializeReportCreation(){
        report = createInstance(reportFile);
    }

}
