package com.QAA_POM_NETOURS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageTest2 {
	WebDriver wd;

	public void initPagetest2(WebDriver wd) {
		this.wd = wd;
	}
	
	public void validate_page() {
		By a1 = By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");
		String srt = wd.findElement(a1).getText();
		System.out.println(srt);
	}
}
