package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.get("https://tutorialsninja.com/demo/index.php?");
		Thread.sleep(1000);
		
		//Home Page 
		System.out.println("Home Page Title: " + driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(1000);
		
		// Registration Page
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(1000);
		System.out.println("Register Page Title: " + driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		Thread.sleep(1000);
		System.out.println("Title after Warning: " + driver.getTitle());
		Thread.sleep(1000);
		WebElement warningMsg = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
		System.out.println("Warning Message: " + warningMsg);
		Thread.sleep(1000);
		
		// First Name with warning
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
		firstName.sendKeys(" Manoj ");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		Thread.sleep(1000);
		String firstNameWarning = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
		Thread.sleep(2000);
		
		// Last Name with warning
		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
		lastName.sendKeys("Kumar");
		Thread.sleep(1000);
		
		// Email
		WebElement email = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
		email.sendKeys("manumanoj123@gmail.com");
		Thread.sleep(1000);
		
		// Mobile Number
		WebElement telephone = driver.findElement(By.xpath("//*[@id=\"input-telephone\"]"));
		telephone.sendKeys("9945099833");
		Thread.sleep(1000);
		
		// Password 
		WebElement password = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
		password.sendKeys("12345");
		Thread.sleep(1000);
		
		// Confirm Password
		WebElement passwordconfirm = driver.findElement(By.xpath("//*[@id=\"input-confirm\"]"));
		passwordconfirm.sendKeys("12345");
		Thread.sleep(1000);
		
		// Radio
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]")).click();
		Thread.sleep(1000);

		// Privacy Policy
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		Thread.sleep(1000);

		// Continue
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		Thread.sleep(1000);

		// Verify
		System.out.println("Your Account Has Been Created!");
		Thread.sleep(1000);

		// Continue
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		Thread.sleep(1000);

		//  View
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[1]/a")).click();
		Thread.sleep(1000);

		driver.quit();
	}

}
