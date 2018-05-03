package com.codebind.maven_demo;

import org.testng.annotations.Test;

import com.common.maven_demo.Base;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class ChromeTest extends Base {
	/*	WebDriver driver;
	String d;
	
	@BeforeTest
	public void URLlanch() throws Throwable{
		System.setProperty("webdriver.chrome.driver","/home/ltuser/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://accounts.lambdatest.com/login");
		
		driver.findElement(By.name("email")).sendKeys("himanshup@lambdatest.com");
		driver.findElement(By.name("password")).sendKeys("Himsani@1991");

		// WebElement button = driver.findElement(By.className("btn"));
		WebElement button = driver.findElement(By.cssSelector(".sign-up-btn"));
		button.click();

		WebElement reallink = driver.findElement(By.xpath("/html/body/div/nav/div[1]/ul/li[2]/a"));
		reallink.click();
		 Thread.sleep(1000);
		    DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
	        Date date = new Date();
	        d=  dateFormat.format(date);
	        File dir = new File("C:/Users/Admin/Desktop/Automation_Testing/Browsers/Afternoon"+d+"");
	        dir.mkdir();
	
	}*/
	
	 @Test(dataProvider = "searchProvider", dataProviderClass = dataproviderclass.class)
	 public void testMethod(String browser, String brosName, String Version, String verName, String OS, String OSName, String Resolution, String ResoName) throws InterruptedException{
//		  driver.navigate().to("https://stage-app.lambdatest.com/console/realtime?client=webrtc");
		  String borwsre = "(//*[@class='list-unstyled real-browser-test__list-browser text-center'])[1]/li["+browser+"]";
		  String Verse = "//*[@class='list-unstyled real-browser-test__list-version']/li["+Version+"]";
		  String NewOS = "//*[@class='list-unstyled real-browser-test__list-os']/li["+OS+"]";
		  String Reso  ="//*[@class='list-unstyled real-browser-test__list-resolution']/li["+Resolution+"]"; 
		 
		  test.log(LogStatus.PASS, "Browser - "+brosName+" Version - "+verName+" OS - "+OSName+" Resolution - "+ResoName);
		  System.out.println("Browser - "+brosName+" Version - "+verName+" OS - "+OSName+" Resolution - "+ResoName);
		  
		  Thread.sleep(3000);
		  
		  WebElement ClickBrowser = driver.findElement(By.xpath(borwsre));
	      //Search text in google text box
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click()", ClickBrowser);
		 
//		  ClickBrowser.click();
	      
		  Thread.sleep(2000);
		  WebElement ClickVersion = driver.findElement(By.xpath(Verse));
	      //Search text in google text box
	      ClickVersion.click();
	     // System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	      Thread.sleep(2000);
	      
	      WebElement ClickOS = driver.findElement(By.xpath(NewOS));
	      //Search text in google text box
	      ClickOS.click();
	      
	      Thread.sleep(2000);
	      WebElement ClickReso = driver.findElement(By.xpath(Reso));
	      //Search text in google text box
	      ClickReso.click();
	      
	 /*   WebElement tunnel = driver.findElement(By.xpath("/html/body/app-root/app-console/app-header/div/div/app-test-detail/section/div/div[1]/div/div[1]/form/div[2]/select"));
	      Select dropdown = new Select(tunnel);
	      dropdown.selectByVisibleText("ltuser-Lenovo-G50-70-1");*/
	      
	      Thread.sleep(1000);
	 
	      WebElement TestUrl = driver.findElement(By.id("input-text"));
	       TestUrl.clear();
			TestUrl.sendKeys("www.amazon.in");
			
			StopWatch pageLoad = new StopWatch();
	        pageLoad.start();
			//long start = System.currentTimeMillis();
			WebElement startbtn = driver.findElement(By.className("btn-start"));
			startbtn.click();    
			
		        WebDriverWait wait = new WebDriverWait(driver, 40);
		        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".blank_canvas")));
	//	        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".display-container div div div canvas"))); 
		        pageLoad.stop();
		        //Get the time
		        long pageLoadTime_ms = pageLoad.getTime();
		        long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
		        System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
		        System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
			
		/*	Thread.sleep(1000);
			
			WebElement rxBtn = driver.findElement(By.cssSelector(".fa.fa-times"));
			Assert.assertEquals(true, rxBtn.isDisplayed());*/
			Thread.sleep(25000);
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("/home/ltuser/Desktop/Automation_Testing/Browsers/Mid-day"+d+"/Screenshot["+brosName+","+verName+","+OSName+","+ResoName+"].png"));
			}
			 
			catch (IOException e)
			 {
			  System.out.println(e.getMessage());
			 
			 }
			 WebElement ExitVM = driver.findElement(By.cssSelector(".menu-7 a"));
				ExitVM.click();
				
			WebElement Exitconf =  driver.findElement(By.cssSelector(".end-butt.yes"));   
			     Exitconf.click();
	  }  
	  
	  @AfterTest
	  public void Close(){
		  driver.close();
	  }
	}
