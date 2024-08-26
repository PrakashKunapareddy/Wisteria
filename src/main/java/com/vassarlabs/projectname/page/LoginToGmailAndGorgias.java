package com.vassarlabs.projectname.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;

public class LoginToGmailAndGorgias {
    WebDriver driver;
    Robot robot;

    private By GmailUserName = By.xpath("//input[@type='email']");
    private By GmailNextButton = By.xpath("//span[text()='Next']/parent::button");
    private By GmailPassWord = By.xpath("//input[@type='password']");
    private By GoogleAppsButton = By.xpath(" //a[@aria-label='Google apps']");
    private By GmailApplication = By.xpath("//span[text()='Gmail']/preceding-sibling::div/span");
    private String GorgiasURL = "https://vassardigital.gorgias.com/idp/login?next=%2Fidp%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26client_id%3D6489dab5477d0a11fc74aa2f%26redirect_uri%3Dhttps%253A%252F%252Fvassardigital.gorgias.com%252Flogin%252Fidp%26scope%3Dopenid%2Bemail%2Bprofile%26state%3DeyJyZXRyeS1jb3VudCI6IDB9%26nonce%3DOULYPDZuksJk7b6KkGOa";
    private By GorgiasUserName = By.xpath("//input[@type='email']");
    private By GorgiasPassWord = By.xpath("//input[@type='password']");
    private By GorgiassignInButton = By.xpath("//button");



    public LoginToGmailAndGorgias(WebDriver driver) throws AWTException {
        this.driver = driver;
        this.robot = new Robot();
    }
    //Gmail Login
    public void GmailLogin(String GmailUN, String GmailPW) throws Throwable{
        enterUsername(GmailUN);
        enterPassword(GmailPW);
        clickOnGoogleAppsAndClickOnGmail();
    }
    //Login to Gorgias
    public void GorgiasLogin(String GorgiasUN, String GorgiasPW) throws Throwable{
        OpnNewTab();
        OpenGorgiasSite();
        LoginIntoGorgias(GorgiasUN,GorgiasPW);
    }

    public void enterUsername(String username) throws Throwable {
        Thread.sleep(3000);
        WebElement un = driver.findElement(GmailUserName);
        un.sendKeys(username);
        clickSignInButton();
    }

    public void enterPassword(String password) throws Throwable {
        Thread.sleep(6000);
        WebElement pw = driver.findElement(GmailPassWord);
        pw.sendKeys(password);
        clickSignInButton();
    }

    public void clickSignInButton() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(GmailNextButton).click();
    }

    public void clickOnGoogleAppsAndClickOnGmail()throws Throwable{
        Thread.sleep(3000);
//        if(driver.findElement(GoogleAppsButton).getAttribute("aria-expanded").equals("false")){
//            driver.findElement(GoogleAppsButton).click();
//        }
//        driver.findElement(GmailApplication).click();
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        System.out.println("Current tab: " + driver.getCurrentUrl());
        driver.findElement(By.xpath("//div[text()='Compose']")).click();
    }

    public void OpnNewTab(){
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    public void OpenGorgiasSite() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        Thread.sleep(3000);
        driver.get(GorgiasURL);
        System.out.println("Current tab: " + driver.getCurrentUrl());
    }
    public void LoginIntoGorgias(String GorgiasUN, String GorgiasPW)throws Throwable{
       Thread.sleep(1000);
       driver.findElement(GorgiasUserName).sendKeys(GorgiasUN);
        driver.findElement(GorgiasPassWord).sendKeys(GorgiasPW);
        driver.findElement(GorgiassignInButton).click();
        driver.findElement(By.xpath("//div/a[contains(@class,'btn btn-primary')]")).click();
       Assert.assertEquals(driver.findElement(By.xpath("//button[@data-candu-id='navbar-user-menu']/div[1]")).getText().trim(),"SaiPrakash");
    }


}
