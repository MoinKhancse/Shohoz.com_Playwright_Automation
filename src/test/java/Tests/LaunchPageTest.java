package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Drivers.BaseDriver;
import Pages.LaunchTicketPage;
import Utilities.ExtentFactory;

public class LaunchPageTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	@Parameters({"url","browserName", "headless"})
	public void openUrl(@Optional("https://www.shohoz.com")String url,
	@Optional("chromium")String browserName,@Optional("false")String headless  ) throws InterruptedException {
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:13px\"><b> Shohoz.com </b></p>").assignAuthor("SQA Team").assignDevice("Windows");
		startPlaywright(browserName,headless);
		launchApplication(url);
	}
	@Test(priority=0)
	public void buyTicket() throws InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#FF6000; font-size:13px\"><b> Launch Ticket </b></p>");
		LaunchTicketPage ticket = new LaunchTicketPage(page, childTest);
		ticket.ticketLaunch();
	}
	
	@Test(priority=1)
	public void buyTrainTicket() throws InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#FF6000; font-size:13px\"><b> Train Ticket </b></p>");
		LaunchTicketPage ticket = new LaunchTicketPage(page, childTest);
		ticket.train();	
	}
	@AfterClass
	public void afterClass() {
		closePlaywright();
		report.flush();
	}
	
	

}
