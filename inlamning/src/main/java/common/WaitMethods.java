package common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethods {

	



	public void click(WebDriver driver, By by) {

		(new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(by));

		driver.findElement(by).click();

}
	
	
	public void elementPresent(WebDriver driver, By by) {
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.

				presenceOfElementLocated(By.id("elementId")));

	}
	
	public void sendKeys(WebDriver driver, By by, String text) {

		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).sendKeys(text);

}
	
	
	
	
	
	
	
}
