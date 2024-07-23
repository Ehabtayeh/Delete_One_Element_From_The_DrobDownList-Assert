package test_Option_Menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestRemove {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\MyWebDriverChrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
		driver.manage().window().maximize();
		List<WebElement> theStudents = driver.findElements(By.tagName("option"));
		int theAllStudents = theStudents.size();
		System.out.println("The original number of students is :  " + theAllStudents);

		int howManyItemsWereDeleted = 1;
		System.out.println("How Many Items Were Deleted =  " + howManyItemsWereDeleted);

		for (int i = 0; i < howManyItemsWereDeleted; i++) {
			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
		}
		List<WebElement> theStudentsAfterRemove = driver.findElements(By.tagName("option"));
		int actualItem = theStudentsAfterRemove.size();
		System.out.println("The actual item  is :  " + actualItem);

		int expectedNumberOfStudents = theAllStudents - howManyItemsWereDeleted;
		System.out.println("The expexted item  is :  " + expectedNumberOfStudents);

		Assert.assertEquals(actualItem, expectedNumberOfStudents);
	}

}
