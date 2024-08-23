package com.vassarlabs.projectname.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    private By userName = By.xpath("//input[@placeholder='Username/Email']");
    private By passWord = By.xpath("//input[@placeholder='Password']");
    private By signInButton = By.xpath("//span[text()=' Sign In ']");
    private By successMessage = By.xpath("//div[@class='page-header']/div/h2[text()='Projects']");
    private By errorMessageIncorrectPassword = By.xpath("//div/mat-hint[text()='Incorrect Password!']");
    private By errorMessageIncorrectUsername = By.xpath("//div/mat-hint[text()='Invalid Username!']");
    private By forgotPassword = By.xpath(" //span[text()=' Forgot Password? ']");
    private By forgotPasswordUsername = By.xpath("//mat-label[text()='Username']/../../../following-sibling::div/input");
    private By forgotPasswordSubmit = By.xpath("//span[text()=' Submit ']/parent::button");
    private boolean flag = true;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) throws InterruptedException {
        Thread.sleep(1000);
        WebElement un = driver.findElement(userName);
        un.sendKeys(username);
    }

    public void enterPassword(String password) throws InterruptedException {
        Thread.sleep(1000);
        WebElement pw = driver.findElement(passWord);
        pw.sendKeys(password);
    }

    public void clickSignInButton() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        boolean Enabledcondition = driver.findElement(signInButton).isEnabled();
        System.out.println("................" + Enabledcondition);

        if (!(driver.findElement(signInButton).isEnabled())) {
            flag = false;
        } else {
            driver.findElement(signInButton).click();
        }

    }

    public void validateLogin(String expected_output, String valid_username) throws Throwable {
        if (flag) {
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            if (driver.findElements(errorMessageIncorrectPassword).size() > 0) {
                String error = driver.findElement(errorMessageIncorrectPassword).getText();
                Assert.assertEquals(expected_output, error, "Expected Error Message " + expected_output + " But Found : " + error);
//                forgotPassword(valid_username);
            }
            if (driver.findElements(errorMessageIncorrectUsername).size() > 0) {
                String error = driver.findElement(errorMessageIncorrectUsername).getText();
                Assert.assertEquals(expected_output, error, "Expected Error Message " + expected_output + " But Found : " + error);
//                forgotPassword(valid_username);
            }
            if (driver.findElements(successMessage).size() > 0) {
                String success = driver.findElement(successMessage).getText();
                System.out.println(success);
                Assert.assertEquals(expected_output, success, "Expected Error Message " + expected_output + " But Found : " + success);
            }
        } else {
            System.out.println("Empty Username Or Password field");
        }
    }
//    public void forgotPassword(String valid_username){
//        driver.findElement(forgotPassword).click();
//        driver.findElement(forgotPasswordUsername).sendKeys(valid_username);
//        driver.findElement(forgotPasswordSubmit).click();
//
//    }
}
