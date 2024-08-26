package com.vassarlabs.projectname.page;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.awt.*;

public class QueryProductAvailability {
    WebDriver driver;
    Robot robot;

    public QueryProductAvailability(WebDriver driver) throws AWTException {
        this.driver = driver;
        this.robot = new Robot();
    }

    private By allTickets = By.xpath("//span[text()='All']/parent::span/i");
//    private By allTickets = By.xpath("");

//    Click On All Tickets In Gorgias
    public void clickOnALlTickets() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(allTickets).click();
    }
    //Send mail From Gmail To Gorgias
    public void clickOnSentMailAndAccessProductAvailabilityThread(String Query, String SKUID) throws Throwable {
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(0));
        driver.findElement(By.xpath("//a[text()='Sent']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@aria-label='Advanced search options']")).click();
        driver.findElement(By.xpath("//label[text()='Subject']/parent::span/parent::div//input")).sendKeys(Query);
        driver.findElement(By.xpath("//div[text()='Search'][@data-tooltip='Search Mail']")).click();
        driver.findElement(By.xpath("//table/tbody/tr//span/span[text()='Product']/parent::span")).click();
        driver.findElement(By.xpath("//span[text()='Reply'][@role='link']")).click();
        String emailBody = "Hi,\n" +
                "Let me know the product availability of the product with SKU ID " + SKUID + ".\n" +
                "Thank you";
        driver.findElement(By.xpath("//div[@aria-label='Message Body'][@role='textbox']")).sendKeys(emailBody);
        driver.findElement(By.xpath("//div[@role='button'][text()='Send']")).click();
        Thread.sleep(3000);
        driver.switchTo().window(tabs.get(1));
    }
    //Check for the Query and Switch to The Related Query and Save the Email Content
    public void openGorgiasAndAccessMail(String Query, String ItemAvailability) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'" + Query + "')][contains(@class,'Ticket--subject')]")).click();
        String content = driver.findElements(By.xpath("//p[@class='email_content']")).get(driver.findElements(By.xpath("//p[@class='email_content']")).size() - 1).getText().trim();

        switch (ItemAvailability) {
            case "InStock":
                InStockTemplate(content);
                break;
            case "OutOfStock":
                OutOfStockTemplate(content);
                break;
        }
    }
    //Check The Template For InStock Product
    public void InStockTemplate(String content) {
        String expectedTemplate = "Dear Wisteria Automation, I hope this email finds you well. Thank you for reaching out. Currently, the  is in stock.\n\n" +
                "- Product Name:\n" +
                "- SKU ID: \n" +
                "- Meta Description: \n" +
                "- Product Link:\n\n" +
                "If you have any further questions or concerns, please do not hesitate to contact us.\n\n" +
                "Best regards,\nWisteria Customer Service";

        String actualTemplate = content.replaceAll("(?<=Currently, the ).*(?= is in stock.)", "")
                .replaceAll("(?<=- Product Name: ).*", "")
                .replaceAll("(?<=- SKU ID: ).*", "")
                .replaceAll("(?<=- Meta Description: ).*", "")
                .replaceAll("(?<=- Product Link: ).*", "")
                .replaceAll("\\s+", " ").trim();
        String normalizedExpectedTemplate = expectedTemplate.replaceAll("\\s+", " ").trim();
        System.out.println(normalizedExpectedTemplate);
        System.out.println(actualTemplate);
        Assert.assertEquals(actualTemplate, normalizedExpectedTemplate, "The email template does not match the expected structure.");
    }
    //Check The Template For Out Of Stock Product
    public void OutOfStockTemplate(String content) {
        String expectedOutOfStockTemplate = "Dear Wisteria Automation,\n\n" +
                "I hope this email finds you well. Thank you for reaching out.\n\n" +
                "Currently, the  is out of stock and will not be available again as it has been discontinued.\n\n" +
                "- Product Name: \n" +
                "- SKU ID: \n" +
                "- Meta Description: \n" +
                "- Product Link:\n\n" +
                "If you have any further questions or concerns, please do not hesitate to contact us.\n\n" +
                "Best regards,\nWisteria Customer Service";

        String actualOutOfStockTemplate = content.replaceAll("(?<=Currently, the ).*?(?= is out of stock and will not be available again as it has been discontinued.)", "")
                .replaceAll("(?<=- Product Name: ).*", "")
                .replaceAll("(?<=- SKU ID: ).*", "")
                .replaceAll("(?<=- Meta Description: ).*", "")
                .replaceAll("(?<=- Product Link: ).*", "")
                .replaceAll("\\s+", " ").trim();
        String normalizedExpectedOutOfStockTemplate = expectedOutOfStockTemplate.replaceAll("\\s+", " ").trim();

        System.out.println(normalizedExpectedOutOfStockTemplate);
        System.out.println(actualOutOfStockTemplate);

        Assert.assertEquals(actualOutOfStockTemplate, normalizedExpectedOutOfStockTemplate, "The out-of-stock email template does not match the expected structure.");
    }

}
