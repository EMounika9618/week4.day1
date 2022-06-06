package week4.Day1;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://www.amazon.in/");// load amazon URL

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro"+Keys.ENTER);//search for oneplus 9 pro
		Thread.sleep(3000);

		WebElement P1 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String firstP=P1.getText();//get value of 1st product
		System.out.println("Price of 1st product: "+firstP);
		Thread.sleep(5000);

		// Print the number of customer ratings for firstP
		WebElement P2 = driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style'])[2]/span"));
		System.out.println("Customer review of 1st product: "+P2.getText());
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal']/parent::a)[1]")).click();//click on 1st image
		Thread.sleep(5000);
		Set<String> set = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(set);
		driver.switchTo().window(list.get(1));
		Thread.sleep(3000);

		File source = driver.getScreenshotAs(OutputType.FILE);//taking screenshot
		File destination = new File("./my choice.png");
		FileUtils.copyFile(source, destination);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();//add to cart
		Thread.sleep(3000);

		Set<String> set2 = driver.getWindowHandles();//get no of open tabs
		List<String> list2=new ArrayList<String>(set2);
		driver.switchTo().window(list2.get(1));
		Thread.sleep(1000);
		WebElement P3 = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		String price=P3.getText();
		Thread.sleep(5000);
		System.out.println("Cart price= " +price);//verifying
		if(price.contains(firstP)) {
			System.out.println("added");
		}
		else {
			System.out.println("Not added");
		}

		Thread.sleep(500);
		driver.quit();

	}


}