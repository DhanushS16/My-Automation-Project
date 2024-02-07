package com.MyAutomationProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ComparePrdts {
	

	public static void main(String[] args) {
		String actu_title="COMPARE PRODUCTS";
		String mob1="SONY XPERIA";
		String mob2="IPHONE";
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://live.techpanda.org/index.php/");
		//click mobile menu
		driver.findElement(By.xpath("//a[@class='level0 ']")).click();
		
		//add mobiles to compare
		driver.findElement(By.xpath("(//a[.='Add to Compare'])[1]")).click();
		driver.findElement(By.xpath("(//a[.='Add to Compare'])[2]")).click();
		driver.findElement(By.xpath("//span[.='Compare']")).click();
		
		//handling popup window
		Set<String> wh= driver.getWindowHandles();
		List<String> list= new ArrayList<String>(wh);
		driver.switchTo().window(list.get(1));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String exptd_title= driver.findElement(By.xpath("//h1")).getText();
		if (actu_title.equals(exptd_title)) {
			System.out.println("Verified: PopUp window heading : "+exptd_title);

		} else {
			System.out.println("Test case failed");
		}
		//verify prdts in compare
		String exptd1=driver.findElement(By.xpath("//a[.='Sony Xperia']")).getText();
		String exptd2=driver.findElement(By.xpath("//a[.='IPhone']")).getText();
		if (mob1.equals(exptd1) && mob2.equals(exptd2)) {
			System.out.println("Verified: selected prdts to compare: "+exptd1 +" & "+exptd2);
			System.out.println("Test case: Passed");
		} else {
			System.out.println("Test case: Failed");
		}
		driver.close();
	}

}
