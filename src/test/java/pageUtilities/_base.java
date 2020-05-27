package pageUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class _base {
	
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports report;
    public static ExtentTest logger;
	
	
	@BeforeTest
	public void openBrowser() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/StorTrackReport.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
         
        htmlReporter.config().setChartVisibilityOnOpen(false);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("StorTrack");
        htmlReporter.config().setTheme(Theme.STANDARD);
        
		System.setProperty("webdriver.chrome.driver", "C:\\Surey\\Automation\\ChromeDriver\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
	
//	@AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
        	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
        	logger.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
        	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
        	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
        	logger.skip(result.getThrowable());
        }
    }
	
	
	@AfterTest
	public void tearDown() {
		
		report.flush();
		driver.quit();
	}
			

}
