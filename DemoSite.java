package com.MyAutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoSite {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://live.techpanda.org/index.php/");
		//getPagetitle
//		System.out.println("Home page: "+driver.getTitle());
		String value="THIS IS DEMO SITE FOR   ";
		String demoSite  = driver.findElement(By.cssSelector("h2")).getText();
		System.out.println(demoSite);
		System.out.println("text verify: "+value.equals(demoSite)); //boolean method to check string value
		
		//click mobile menu
		driver.findElement(By.xpath("//a[@class='level0 ']")).click();
		System.out.println("Page title: "+driver.getTitle());
		
		//get drop down menu
		WebElement dmenu=driver.findElement(By.xpath("(//select[@title='Sort By'])[1]"));
		Select mydmenu=new Select(dmenu);
		mydmenu.selectByIndex(1);
		
		
		
		System.out.println("All prdts are sorted by name");
		
		
	}

}
