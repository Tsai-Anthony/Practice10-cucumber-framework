//Create a script that navigates to https://boratech-practice-app.onrender.com/
// it must login
// click on add experience
//	navigate back to dashboard
//	click on add education

package lenaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String landingUrl = "https://boratech-practice-app.onrender.com/";
		String email = "chenlena@outlook.com";
		String password = "798911";

		try {
			// get elements
			driver.get(landingUrl);
			driver.findElement(By.xpath("//a[@class ='btn btn-light']")).click();
			wait(2);

			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@type ='password']")).sendKeys(password);
			wait(2);

			driver.findElement(By.xpath("//input[@type = 'submit']")).click();
			wait(2);

			// Validate URL
			String currentUrl = driver.getCurrentUrl();
			if (!(currentUrl.endsWith("/dashboard"))) {
				throw new Exception("you are not on the correct page");
			}

			// Click add experience
			driver.findElement(By.xpath("//a[@href='/add-experience']")).click();
			wait(2);
			// Validate URL
			if (!(currentUrl.endsWith("/add-experience"))) {
				throw new Exception("you are not on the correct page");
			}

			// go back to the dash board
			driver.findElement(By.xpath("//a[@class='btn btn-light my-1']")).click();
			wait(2);
			// Validate URL
			if (!(currentUrl.endsWith("/dashboard"))) {
				throw new Exception("you are not on the correct page");
			}

			// Click add education
			driver.findElement(By.xpath("//a[@href='/add-education']")).click();
			wait(2);
			// Validate URL
			if (!(currentUrl.endsWith("/add-education"))) {
				throw new Exception("you are not on the correct page");
			}

		} catch (Exception e) {
			System.out.println("test fail");
			System.out.println(e.getMessage());
		} finally {
			driver.quit();
		}

	}

	public static void wait(int seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);

	}
}
