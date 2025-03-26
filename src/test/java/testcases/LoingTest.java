package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPageObject;
import resources.base;

public class LoingTest extends base {

	@BeforeMethod
	public void initilation() throws InterruptedException, IOException {
		initilization();
		Thread.sleep(1000);
	}

	@Test(dataProvider = "Validlogindata")
	public void Validlogin(String accoutnname, String username, String password) {
		LoginPageObject login = new LoginPageObject(driver);
		login.getAccountName().sendKeys(accoutnname);
		login.getUserName().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getSelectSIGNINBtn().click();
	}

	@Test(dataProvider = "Invalidlogindata")
	public void Invalidlogin(String accoutnname, String username, String password) {

		LoginPageObject login = new LoginPageObject(driver);
		login.getAccountName().sendKeys(accoutnname);
		login.getUserName().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getSelectSIGNINBtn().click();

		// Validate Toast message
		WebElement toastmessage = driver
				.findElement(By.xpath("//div[@role='alert' and contains(@class, 'toast-message')]"));
		String ActualMessage = toastmessage.getText();
		String ExpectedMessage = "Please enter valid credentials.";
		Assert.assertEquals(ActualMessage, ExpectedMessage, "Toast message text is incorrect.");
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

	// Start DataProvider
	@DataProvider
	public Object[][] Validlogindata() {
		return new Object[][] { { "NB001", "Admin", "Sit@1234" } };
	}

	@DataProvider
	public Object[][] Invalidlogindata() {
		return new Object[][] { { "NB002", "Admin1", "Sit@1234S" } };
	}

}
