package rahulshettypack;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RahulShettyClass {
	
	public static void main(String[]arg) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		//opening up browser link
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
//-	Radio buttons		
		//Declaring our radio buttons
		WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));							
		WebElement radio2 = driver.findElement(By.xpath("//input[@value='radio2']"));
		WebElement radio3 = driver.findElement(By.xpath("//input[@value='radio3']"));
		
		radio3.click();
		Thread.sleep(2000);
		boolean selectState = radio3.isSelected();
		
		//performing click operation only if element is not selected
		
		if(selectState) {
			System.out.println("Radio Button 3 is selected");
		}else {
			System.out.println("Radio Button 3 is not selected");
		}
		
 
		radio2.click();
		Thread.sleep(2000);
		boolean selectState1 = radio2.isSelected();
		if(selectState1) {
			System.out.println("Radio Button 2 is selected");
		}else {
			System.out.println("Radio Button 2 is not selected");
		}
		
//-	Suggestion		
	    WebElement Suggestion = driver.findElement(By.id("autocomplete"));
		Suggestion.sendKeys("South");
		
		Thread.sleep(2000);
		List <WebElement> autoSelect = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		Thread.sleep(2000);
		
			for (int i =0; i<autoSelect.size();i++) 
			if (autoSelect.get(i).getText().equalsIgnoreCase("South Africa")){
			
			autoSelect.get(i).click();
			
		}
			Thread.sleep(2000);
			Suggestion.clear();
			Suggestion.sendKeys("Republic");
			Thread.sleep(2000);
			Suggestion.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			Suggestion.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
//-	Checkboxes
		//Declaring our Checkboxes
		WebElement Checkbox1 = driver.findElement(By.id("checkBoxOption1"));							
		WebElement Checkbox2 = driver.findElement(By.id("checkBoxOption2"));
		WebElement Checkbox3 = driver.findElement(By.id("checkBoxOption3"));
				
		Checkbox1.click();
		Thread.sleep(2000);
		Checkbox2.click();
		Thread.sleep(2000);
		Checkbox3.click();
		//1st
		if(!Checkbox1.isSelected()) {
			System.out.println("Checkbox1 number is not checked");
		} else {
			System.out.println("Checkbox 1 number is checked");
		}
		//2nd
		if(!Checkbox2.isSelected()) {
			System.out.println("Checkbox2 number is not checked");
		} else {
			System.out.println("Checkbox 2 number is checked");
		}
		//3rd
		if(!Checkbox3.isSelected()) {
			System.out.println("Checkbox3 number is not checked");
		} else {
			System.out.println("Checkbox 3 number is checked");
		}
		
		//Uncheck opt1
		Thread.sleep(2000);
		Checkbox1.click();
		
		if(!Checkbox2.isSelected() && !Checkbox3.isSelected()) {
			System.out.println("Checkbox 2 and 3 number is not checked");
		} else {
			System.out.println("Checkbox 2 and 3 number is checked");
		}
		
//Web Table Fixed header
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		//Validate that the Amount for  ‘Joe Postman’ from ‘Chennai’ has an amount of 46
		System.out.println(driver.findElement(By.xpath("//legend[contains(text(),'Web Table Fixed header')]")).getText());
		System.out.println(driver.findElement(By.xpath("(//td[text()='46'])")).getText());
		String JoePostAmnt = driver.findElement(By.xpath("(//td[text()='46'])")).getText();
		
		if(JoePostAmnt.equalsIgnoreCase("46")) {
			System.out.println(JoePostAmnt + "Is correct");
		}else {
			System.out.println(JoePostAmnt + "Is not correct");
		}
		
		//Validating total.
		String Total = driver.findElement(By.xpath("//div[text()=' Total Amount Collected: 296 ']")).getText();
		
		if(Total.trim().equalsIgnoreCase("Total Amount Collected: 296")) {
			System.out.println(Total + " total amount collected Is correct");
		}else {
			System.out.println(Total + "total amount collected Is not correct");
		}
		
//-	Show / hide
		WebElement Hide = driver.findElement(By.id("hide-textbox"));
		Hide.click();
		
		WebElement HiddenField = driver.findElement(By.id("displayed-text"));
		
		if(HiddenField.isDisplayed()){
			System.out.println("Element not hidden Successfully");
		} else {
			System.out.println("Element is hidden Successfully");
		}
		Thread.sleep(2000);
		WebElement Show = driver.findElement(By.id("show-textbox"));
		Show.click();
		
		if(HiddenField.isDisplayed()){
			System.out.println("Element un-hidden Successfully");
		} else {
			System.out.println("Element is still hidden Successfully");
		}

//-	iFrame
		
		
		List <WebElement> FramesNum = driver.findElements(By.tagName("iframe"));
		System.out.println( "Page has" + " " + FramesNum.size() + " " + "iFrame.");
		
		WebElement iframe = driver.findElement(By.id("courses-iframe"));
		driver.switchTo().frame(iframe);
		System.out.println(driver.findElement(By.xpath("(//a[text()='Mentorship'])[1]")).getText());
		driver.findElement(By.xpath("(//a[text()='Mentorship'])[1]")).click();
		//Mentorship
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		driver.close();
		
	}

	private static WebElement findElement(By id) {
		// TODO Auto-generated method stub
		return null;
	}

}
