package journey.details;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectQuota {
	public static void TrainQuota(WebDriver driver, String QuotaClass,WebDriverWait wait, String TrainName) throws InterruptedException {	
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + TrainName + "')]")));
		WebElement remove_aunty = driver.findElement(By.xpath("//*[@class='removeicon']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", remove_aunty);
		
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='ui-dropdown-trigger-icon ui-clickable fa fa-fw fa-caret-down'])[5]")));
		driver.findElement(
				By.xpath("(//*[@class='ui-dropdown-trigger-icon ui-clickable fa fa-fw fa-caret-down'])[5]"))
				.click();
		System.out.println(QuotaClass);
		if (QuotaClass.equals("GENERAL")) {
			driver.findElement(By.xpath("//span[.='GENERAL']")).click();
		} else if (QuotaClass.equals("LOWER BERTH/SR.CITIZEN")) {
			driver.findElement(By.xpath("//span[.='LOWER BERTH/SR.CITIZEN']")).click();
		} else if (QuotaClass.equals("LADIES")) {
			driver.findElement(By.xpath("//span[.='LADIES']")).click();
		} else if (QuotaClass.equals("DIVYAANG")) {
			driver.findElement(By.xpath("//span[.='DIVYAANG']")).click();
		} else if (QuotaClass.equals("TATKAL")) {
			driver.findElement(By.xpath(
					"//span[.='TATKAL']"))
					.click();
		} else {
			driver.findElement(By.xpath(
					"//span[.='PREMIUM TATKAL']"))
					.click();
		}
	}
}
