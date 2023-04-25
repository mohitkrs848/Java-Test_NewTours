package com.QAA_POM_NETOURS;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class PageTest1 {

	// step-1
	// Declare the webdriver

	WebDriver wd;
	FileReader fr;
	Properties p = new Properties();

	// step-2
	// Declare the locator

	By u1 = By.xpath("//input[@name=\"userName\"]");
	By p1 = By.xpath("//input[@name=\"password\"]");
	By s1 = By.xpath("//input[@type=\"submit\"]");

	// step-3
	// Initialize the webdriver

	public void initpagetest1(WebDriver wd) {
		this.wd = wd;
	}

	// method automation
	public void fun_enter_launchapp() {
		// System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");
//		wd = new FirefoxDriver();
		wd.get("https://demo.guru99.com/test/newtours/");
		String exp1 = "Welcome: Mercury Tours";
		String act1 = wd.getTitle();
		if (act1.equals(exp1)) {
			System.out.println("The page is launched successfully.");
		} else {
			System.out.println("404 Error Not Found");
		}
		Assert.assertEquals(act1, exp1);
	}

	public void fun_enter_username() throws IOException {
		fr = new FileReader(".//TestData//testdata.properties");
		p.load(fr);
		if (wd.findElement(u1).isDisplayed()) {
			System.out.println("User Name is present.");
			wd.findElement(u1).sendKeys(p.getProperty("username"));
		} else {
			System.out.println("User name is not present.");
		}

	}

	public void fun_enter_password() throws FileNotFoundException, IOException {
		fr = new FileReader(".//TestData//testdata.properties");
		p.load(fr);
		wd.findElement(p1).sendKeys(p.getProperty("password"));
	}

	public void fun_click_signin() {
		wd.findElement(s1).click();
	}
}
