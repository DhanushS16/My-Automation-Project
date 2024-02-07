package com.MyAutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyPrdtCost {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://live.techpanda.org/index.php/"); //step-1
		
		//click mobile menu
		driver.findElement(By.xpath("//a[@class='level0 ']")).click(); //step-2
		WebElement price= driver.findElement(By.xpath("//span[.='$100.00']")); //step-3
		String p1= price.getText();
		driver.findElement(By.xpath("//a[@title='Xperia']")).click(); //step-4
		System.out.println(driver.getTitle()); //step-5
		
		WebElement mob_price= driver.findElement(By.xpath("//span[.='$100.00']"));
		String p2= mob_price.getText();
		System.out.println("Prdt value in list and detail page is equal($100.00): "+ p1.equals(p2)); //step-6
		
	}

}
