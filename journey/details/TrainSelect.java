package journey.details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainSelect {
	public static void trainOption(WebDriver driver, WebDriverWait wait,String TrainName) {
		
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + TrainName + "')]")));
		RemoveLogo.RemoveIcon(driver);
	}
	
	public static void trainSelect(WebDriver driver, WebDriverWait wait,String TrainName,String TrainSequence) throws InterruptedException {
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + TrainName + "')]")));
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + TrainName + "')]"));
		Actions action = new Actions(driver);
		action.moveToElement(element);
		driver.findElement(By.xpath("(//*[@id=\"check-availability\"])[" + TrainSequence + "]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@ptooltip='Refresh']")));
		while (!driver.findElement(By.xpath("(//*[text()='Book Now'])[2]")).isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@ptooltip='Refresh']")));
			driver.findElement(By.xpath("//*[@ptooltip='Refresh']")).click();
			Thread.sleep(3000);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Book Now'])[2]")));
		WebElement element1 = driver.findElement(By.xpath("(//*[text()='Book Now'])[2]"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(element1);
		driver.findElement(By.xpath("(//*[text()='Book Now'])[2]")).click();
	}
	
}
