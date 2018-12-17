package journey.details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JourneyDetails {

	public static void journey(WebDriver driver, String from, String to, String Date,WebDriverWait wait) {
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From*']")));
		driver.findElement(By.xpath("//input[@placeholder='From*']")).sendKeys(from);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To*']")));
		driver.findElement(By.xpath("//input[@placeholder='To*']")).sendKeys(to);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Journey Date(dd-mm-yyyy)*']")));
		driver.findElement(By.xpath("//input[@placeholder='Journey Date(dd-mm-yyyy)*']")).sendKeys("13-02-2052");
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Find trains')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Find trains')]")).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Journey Date(dd-mm-yyyy)*']")));
		driver.findElement(By.xpath("//input[@placeholder='Journey Date(dd-mm-yyyy)*']")).sendKeys(Date);
	}

	public static void journeyClass(WebDriver driver, String train_class,WebDriverWait wait) {
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ui-dropdown-trigger-icon ui-clickable fa fa-fw fa-caret-down']")));
		driver.findElement(By.xpath("//span[@class='ui-dropdown-trigger-icon ui-clickable fa fa-fw fa-caret-down']"))
				.click();
		if (train_class.equals("Anubhuti Class (EA)")) {
			driver.findElement(By.xpath(
					"//span[.='Anubhuti Class (EA)']"))
					.click();
		} else if (train_class.equals("AC First Class (1A)")) {
			driver.findElement(By.xpath(
					"//span[.='AC First Class (1A)']"))
					.click();
		} else if (train_class.equals("Exec. Chair Car (EC)")) {
			driver.findElement(By.xpath(
					"//span[.='Exec. Chair Car (EC)']"))
					.click();
		} else if (train_class.equals("AC 2 Tier (2A)")) {
			driver.findElement(By.xpath(
					"//span[.='AC 2 Tier (2A)']"))
					.click();
		} else if (train_class.equals("First Class (FC)")) {
			driver.findElement(By.xpath(
					"//span[.='First Class (FC)']"))
					.click();
		} else if (train_class.equals("AC 3 Tier (3A)")) {
			driver.findElement(By.xpath(
					"//span[.='AC 3 Tier (3A)']"))
					.click();
		} else if (train_class.equals("AC 3 Economy (3E)")) {
			driver.findElement(By.xpath(
					"//span[.='AC 3 Economy (3E)']"))
					.click();
		} else if (train_class.equals("AC Chair car (CC)")) {
			driver.findElement(By.xpath(
					"//span[.='AC Chair car (CC)']"))
					.click();
		} else if (train_class.equals("Sleeper (SL)")) {
			driver.findElement(By.xpath(
					"//span[.='Sleeper (SL)']"))
					.click();
		} else {
			driver.findElement(By.xpath(
					"//span[.='Second Sitting (2S)"))
					.click();
		}
	}
	
	public static void findTrain(WebDriver driver,WebDriverWait wait) {
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Find trains')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Find trains')]")).click();
	}
}
