package Validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class Lab6_Validations {
    public static void main(String[] args) {
    	
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        // Maximize window and set implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to TutorialsNinja demo site
        driver.get("https://tutorialsninja.com/demo/index.php?");

        // Navigate to Login page
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();

        // Enter login credentials and submit
        driver.findElement(By.id("input-email")).sendKeys("manumanoj123@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Navigate to Components > Monitors
        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Monitors')]")).click();

        // Change Show dropdown to 25 items
        Select show = new Select(driver.findElement(By.id("input-limit")));
        show.selectByVisibleText("25");

        // Select second product
        WebElement secondProduct = driver.findElement(By.xpath("(//div[contains(@class,'product-thumb')])[1]//div[@class='caption']//a"));
        String firstProductName = secondProduct.getText();
        secondProduct.click();

        // Open Specification tab
        driver.findElement(By.xpath("//a[normalize-space()='Specification']")).click();
        String specText = driver.findElement(By.id("tab-specification")).getText();
        System.out.println("Specification present for: " + firstProductName);
        System.out.println(specText);

        // Add product to Wish List
        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
        String wishMsg = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        System.out.println("Wish List Message: " + wishMsg);

        // Go back to home page
        driver.get("https://tutorialsninja.com/demo/");

        // Search for Mobile
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Mobile");
        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();

        // Click on Search in product descriptions
        WebElement descriptionCheckbox = driver.findElement(By.id("description"));
        if (!descriptionCheckbox.isSelected()) {
            descriptionCheckbox.click();
        }

        // Click search button
        driver.findElement(By.id("button-search")).click();

        // Open HTC Touch HD product page
        driver.findElement(By.linkText("HTC Touch HD")).click();

        // Update quantity to 3 and add to cart
        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");
        driver.findElement(By.id("button-cart")).click();

        // Print cart confirmation message
        String cartMsg = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        System.out.println("Cart Message: " + cartMsg);

        // Logout from account
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Logout")).click();

        // Verify logout page
        String logout = driver.findElement(By.xpath("//h1[contains(text(),'Account Logout')]")).getText();
        System.out.println("Logout Verified: " + logout);

        // Click Continue after logout
        driver.findElement(By.linkText("Continue")).click();

        // Close the browser
        driver.quit();
    }
}
