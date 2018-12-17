package journey.details;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RemoveLogo {
	public static void RemoveIcon(WebDriver driver) {
		WebElement remove_aunty = driver.findElement(By.xpath("//*[@class='removeicon']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", remove_aunty);
	}
}
