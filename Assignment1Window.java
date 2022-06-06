package week4.Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1Window {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");//launch URL
		driver.manage().window().maximize(); 		// maximize the window

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String Parent = driver.getWindowHandle();
		driver.findElement(By.id("home")).click();//click on home

		Set<String> win = driver.getWindowHandles();
		List<String> l1 = new ArrayList<String>(win);
		driver.switchTo().window(l1.get(1));
		driver.close();
		driver.switchTo().window(Parent);
		 driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		  
		  Set<String> win1 = driver.getWindowHandles(); 
		  List<String> l2=new ArrayList<String>(win1);
		  System.out.println(l2.size()); //size
		  for (int i = 1; i < l2.size(); i++) {
			  System.out.println(driver.switchTo().window(l2.get(i)).getTitle());
			  driver.close();
		     }
		   driver.switchTo().window(Parent); 
			 driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
			 Set<String> win3 = driver.getWindowHandles();
			 List<String> l4=new ArrayList<String>(win3);
			 for (int i = 1; i < l4.size(); i++) {
				 Thread.sleep(5000);
				 System.out.println(driver.switchTo().window(l4.get(i)).getTitle());
				 driver.close();
			  }
			 System.out.println("Wait for Windows");
			 driver.switchTo().window(Parent);
			  driver.findElement(By.id("color")).click();
			  System.out.println("test"); Set<String> win2 = driver.getWindowHandles();
			  List<String> l3=new ArrayList<String>(win2);
			  System.out.println(l3.size());
			  for (int i = 1; i < l3.size(); i++) {
					 
					 driver.switchTo().window(l3.get(i));
					 
				  }
			  driver.switchTo().window(Parent);
			  Thread.sleep(5000);  
			  System.out.println("successed");
			  driver.close();
		
		

	}

}
