package Pages;

import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class LaunchTicketPage {
	
	Page page;
	ExtentTest test;
	
	public LaunchTicketPage(Page page,ExtentTest test) {
		this.page = page;
		this.test = test;
	}
	
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+ message+ "</b><p/>");
	}
	
	public void passCaseWithSC(String message, String scName) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>Click button success</b><p/>");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./ScreenShots/"+scName+".png")).setFullPage(true));
		String dest = System.getProperty("user.dir")+"/ScreenShots/" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	public void failCaseWithSC(String message, String scName) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+ message+ "</b><p/>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./ScreenShots/"+scName+".png")).setFullPage(true));
		String dest = System.getProperty("user.dir")+"/ScreenShots/" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());		
	}
	
	public void ticketLaunch() throws InterruptedException {
		ElementHandle launch = page.querySelector("//span[@class='text-xs font-semibold text-right ml-2'][normalize-space()='Launch']");
		launch.click();
		Thread.sleep(2000);
		
		ElementHandle dest_form = page.querySelector("//input[@id='dest_from']");
		dest_form.fill("Dhaka");
		passCase("You have Success Form");
		Thread.sleep(2000);
		
		ElementHandle dest_to = page.querySelector("//input[@id='dest_to']");
		dest_to.fill("Barisal");
		passCase("You have Success To");
		Thread.sleep(2000);
		
		ElementHandle date_click = page.querySelector("//div[@class='col-md-12']//img[@title='...']");
		date_click.click();
		Thread.sleep(2000);
		
		ElementHandle date = page.querySelector("//a[normalize-space()='24']");
		date.click();
		passCase("You have Success Date");
		Thread.sleep(2000);
		
		ElementHandle Search_Launches = page.querySelector("//button[normalize-space()='Search Launches']");
		Search_Launches.click();
		passCaseWithSC("You have successfully click ", "Launch_Ticket");
		Thread.sleep(5000);
	}
	
	public void train() throws InterruptedException {
		ElementHandle Train = page.querySelector("//a[contains(text(),'Train')]");
		Train.click();
		passCase("You have Success Click Train");
		Thread.sleep(5000);
		
		ElementHandle AGREE = page.querySelector("//button[normalize-space()='I AGREE']");
		AGREE.click();
		Thread.sleep(3000);
		
		ElementHandle Login = page.querySelector("//a[normalize-space()='Login']");
		Login.click();
		Thread.sleep(3000);
		
		ElementHandle mobile_number = page.querySelector("//input[@id='mobile_number']");
		mobile_number.fill("01717511288");
		Thread.sleep(3000);
		
		ElementHandle password = page.querySelector("//input[@id='password']");
		password.fill("01717511288");
		Thread.sleep(3000);
		
		ElementHandle submit = page.querySelector("//button[@type='submit']");
		submit.click();
		Thread.sleep(3000);
		
		ElementHandle dest_from = page.querySelector("//input[@id='dest_from']");
		dest_from.hover();
		dest_from.fill("Dhaka");
		Thread.sleep(3000);
		
		ElementHandle des_to = page.querySelector("//input[@id='dest_to']");
		des_to.fill("Khulna");
		Thread.sleep(3000);
		
		ElementHandle img = page.querySelector("//img[@title='...']");
		img.click();
		passCase("You have Success Click");
		Thread.sleep(3000);
		
		ElementHandle dat = page.querySelector("//a[normalize-space()='27']");
		dat.click();
		passCase("You have Success Click");
		Thread.sleep(3000);
		
		ElementHandle choose_class = page.querySelector("//select[@id='choose_class']");
		choose_class.selectOption("S_CHAIR");
		passCase("You have Success Click");
		Thread.sleep(3000);
		
		ElementHandle Search_Trains = page.querySelector("//button[normalize-space()='Search Trains']");
		Search_Trains.click();
		passCase("You have Success Click");
		Thread.sleep(2000);
		passCaseWithSC("You have successfully click ", "Train_Ticket");
		
		ElementHandle BOOK_NOW = page.querySelector("(//button[@type='button'][normalize-space()='BOOK NOW'])[3]");
		BOOK_NOW.click();
		Thread.sleep(2000);
		
		ElementHandle select = page.querySelector("//select[@id='select-bogie']");
		select.selectOption("6");
		Thread.sleep(2000);
		
		ElementHandle THA = page.querySelector("//button[normalize-space()='THA-10']");
		THA.click();
		Thread.sleep(5000);
		
		ElementHandle PURCHASE = page.querySelector("//button[normalize-space()='CONTINUE PURCHASE']");
		PURCHASE.click();
		Thread.sleep(6000);
		}

}
