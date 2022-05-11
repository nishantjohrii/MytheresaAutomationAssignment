package assignment;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 {
	
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else {
			System.out.println("Browser is invalid");
		}
		
		driver.get("https://www.mytheresa.com/ende/men.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement myAccount = driver.findElement(By.id("myaccount"));
		Actions action = new Actions(driver);
		action.moveToElement(myAccount).perform();
		
		WebElement createAccount = driver.findElement(By.xpath("//span[contains(text(),'create an account')]"));
		createAccount.click();
		
		WebElement selectSalutation = driver.findElement(By.xpath("//ul[@id='prefix']/li[3]"));
		selectSalutation.click();
		
		WebElement firstName = driver.findElement(By.id("firstname"));
		firstName.sendKeys("Nishant");
		
		WebElement lastName = driver.findElement(By.id("lastname"));
		lastName.sendKeys("Johri");
		
		WebElement emailAddress = driver.findElement(By.id("email_address"));
		emailAddress.sendKeys("nishantjohri@maildrop.cc");
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Mytheresa@123");
		
		WebElement confirmPassword = driver.findElement(By.id("confirmation"));
		confirmPassword.sendKeys("Mytheresa@123");
		
		WebElement isSubscribed = driver.findElement(By.id("is_subscribed"));
		isSubscribed.click();
		
		WebElement regButton = driver.findElement(By.id("qa-registration-form-register-button"));
		regButton.click();
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		
	}
	}


