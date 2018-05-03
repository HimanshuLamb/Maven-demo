package com.common.maven_demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base {
	public static ExtentTest test;
	public static ExtentReports extent;
	protected WebDriver driver;
	protected String d;
	
	@BeforeTest
	public void URLlanch() throws Throwable{
		System.setProperty("webdriver.chrome.driver","/home/ltuser/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://accounts.lambdatest.com/login");
		 
		driver.findElement(By.name("email")).sendKeys("himanshup@lambdatest.com");
		driver.findElement(By.name("password")).sendKeys("Himsani@1991");

		// WebElement button = driver.findElement(By.className("btn"));
		WebElement button = driver.findElement(By.cssSelector(".sign-up-btn"));
		button.click();

		WebElement reallink = driver.findElement(By.xpath("/html/body/div/nav/div[1]/ul/li[2]/a"));
		reallink.click();
		 Thread.sleep(1000);
		
	        File dir = new File("/home/ltuser/Desktop/Automation_Testing/Browsers/Mid-day"+d+"");
	        dir.mkdir();
	       
	}
	

    @BeforeSuite
    public void before() throws IOException {
        // Create Result repository for report.
    	  DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
	        Date date = new Date();
	        d=  dateFormat.format(date);  
	        File dir1 = new File("/home/ltuser/Desktop/Automation_Testing/Reports/"+d+"");
	        dir1.mkdir();
        extent = new ExtentReports( "/home/ltuser/Desktop/Automation_Testing/Reports/"+d+"/CustomReport.html", true);
    }


  @AfterMethod
    public void afterMainMethod(ITestResult result) throws IOException, InterruptedException {

        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot();
        }       
        extent.endTest(test);
    }

    @BeforeMethod
    public void setTest(Method method) {
        test = extent.startTest(method.getName(), this.getClass().getName());
        test.assignAuthor("Lambdatest");
        test.assignCategory(this.getClass().getSimpleName());
    }

    @AfterSuite
    public void tearDownSuite() throws IOException {
        extent.flush();
        extent.close();
}
    public static String getFileName(String file) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		Calendar cal = Calendar.getInstance();
		String fileName = file + dateFormat.format(cal.getTime());
		return fileName;
	}
    
    /** Capturing screenshot once script is failed */
    public void captureScreenshot() {
        String fileName = System.getProperty("className");
        try {
            String screenshotName = getFileName(fileName);
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screen = null;
            String path = "/home/ltuser/Desktop/Automation_Testing/Reports/"+d+"";
            new File(path).mkdirs();
            screen = path + "/" + "Failed_" + screenshotName + ".png";
            File screenshotLocation = new File(screen);
            FileUtils.copyFile(screenshot, screenshotLocation);
            Thread.sleep(2000);
            InputStream is = new FileInputStream(screenshotLocation);
            byte[] imageBytes = IOUtils.toByteArray(is);
            Thread.sleep(2000);
            String base64 = Base64.getEncoder().encodeToString(imageBytes);
            test.log(LogStatus.FAIL, "Failed_" + fileName + " \n Snapshot below: " + test.addBase64ScreenShot(
                    "data:image/png;base64," + base64));
            Reporter.log("<a href= '" + screen + "'target='_blank' ><img src='" + screen + "'>" + screenshotName
                    + "</a>");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

}
