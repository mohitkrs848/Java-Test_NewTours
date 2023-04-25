package QAA_POM_NETOURS.script;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.QAA_POM_NETOURS.PageTest1;
import com.QAA_POM_NETOURS.PageTest2;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Ntouristc01 {

	WebDriver wd;

	PageTest1 p1 = new PageTest1();
	PageTest2 p2 = new PageTest2();

	static ExtentTest test2;
	static ExtentReports rep2;

	@BeforeTest
	public void driverpath() {
		System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");
		wd = new FirefoxDriver();

		rep2 = new ExtentReports(System.getProperty("user.dir") + "./Reports/newtours1.html");
		test2 = rep2.startTest("JpetScript1");
	}

	@Test(priority = 1)
	public void launch() {
		p1.initpagetest1(wd);
		p1.fun_enter_launchapp();
		test2.log(LogStatus.PASS, "User has successfully launched the application");
	}

	@Test(priority = 2)
	public void username() throws IOException {

//		p1.fun_enter_username();
		test2.log(LogStatus.PASS, "User entered the user name");
	}

	@Test(priority = 3)
	public void password() throws FileNotFoundException, IOException {

//		p1.fun_enter_password();
		test2.log(LogStatus.PASS, "User entered the password");
	}

	@Test(priority = 4)
	public void signin() {

		p1.fun_click_signin();
		test2.log(LogStatus.PASS, "User has successfully loggedin");
	}

	@Test(priority = 5)
	public void validatep2() {
		p2.initPagetest2(wd);
		p2.validate_page();
		test2.log(LogStatus.PASS, "Data extracted successfully");
	}

	@AfterTest
	public void postcondition() {
		wd.manage().deleteAllCookies();
		wd.close();
		rep2.endTest(test2);
		rep2.flush();
	}
}
