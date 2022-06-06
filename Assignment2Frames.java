package week4.Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2Frames {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");//launch URL
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));	
		 WebElement web=driver.findElement(By.id("frame1"));
		 driver.switchTo().frame(web);
		 Thread.sleep(30);
		 WebElement web1 = driver.findElement(By.xpath("//body//input"));
		 web1.click();
		 web1.sendKeys("data entered");
		 System.out.println("test");
		 WebElement web2=driver.findElement(By.id("frame3"));
		 driver.switchTo().frame(web2);
		 Thread.sleep(40);
		 WebElement web3 = driver.findElement(By.id("a"));
		 web3.click();
		 System.out.println("test 2");
		 Thread.sleep(40);
		 driver.switchTo().defaultContent();
		 WebElement web4=driver.findElement(By.xpath("//iframe[@id='frame2']"));
		 driver.switchTo().frame(web4);
		 
		 WebElement web5 = driver.findElement(By.xpath("//select[@id='animals']"));
		 Select opt=new Select(web5);
		 opt.selectByValue("babycat");
		 System.out.println("Baby Cat is selected");
		// Thread.sleep(40);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));	

		driver.close();
		
		

	}

}
