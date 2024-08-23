package com.vassarlabs.projectname.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SamplePage {
    WebDriver driver;

    private By inputtest = By.id("my-other-div");
    private By otherinput = By.id("my-input");

    public SamplePage(WebDriver driver){
        this.driver = driver;
    }

    public void test(String name) throws InterruptedException {
        driver.findElement(inputtest).sendKeys(name);
        System.out.println(driver.findElement(inputtest).getAttribute("value")+"    value");
        System.out.println(driver.findElement(otherinput).getAttribute("value")+"    value 2");
        Thread.sleep(5000);
    }
}
