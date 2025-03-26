package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

	public WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAccountName() {
		By accountname = By.xpath("//input[@formcontrolname='agencyName']");
		return driver.findElement(accountname);
	}

	public WebElement getUserName() {
		By Username = By.xpath("//input[@formcontrolname='userName']");
		return driver.findElement(Username);
	}

	public WebElement getPassword() {
		By password = By.xpath("//input[@formcontrolname='password']");
		return driver.findElement(password);
	}

	public WebElement getSelectSIGNINBtn() {
		By signinbtn = By.xpath("//button[@type='submit']");
		return driver.findElement(signinbtn);
	}

}
