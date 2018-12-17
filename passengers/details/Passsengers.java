package passerngers.details;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Passsengers {

	public static void passendersDetails(WebDriver driver,int i,String passengerName,String passengerAge,String gender,String birth,WebDriverWait wait)
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='psgn-name'])[" + i + "]")));
		driver.findElement(By.xpath("(//input[@id='psgn-name'])[" + i + "]")).clear();
		driver.findElement(By.xpath("(//input[@id='psgn-name'])[" + i + "]"))
		.sendKeys(passengerName);
		driver.findElement(By.xpath("(//input[@placeholder='Age'])[" + i + "]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='Age'])[" + i + "]"))
				.sendKeys(passengerAge);
		Select sel1 = new Select(
				driver.findElement(By.xpath("(//select[@formcontrolname='passengerGender'])[" + i + "]")));
		sel1.selectByVisibleText(gender);
		Select sel2 = new Select(
				driver.findElement(By.xpath("(//select[@formcontrolname='passengerBerthChoice'])[" + i + "]")));
		sel2.selectByVisibleText(birth);
	}
}
