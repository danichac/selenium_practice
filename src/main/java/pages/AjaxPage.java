package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/22/2021
 */
public class AjaxPage {
    private final WebDriver driver;
    private final By buttonLocator = By.id("ajaxButton");
    private final By contentLocator = By.xpath("//p[@class='bg-success']");

    public AjaxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTriggerAjax(){
    	/*
    	 * I try to wait until the element I am interacting with appears, or
    	 * until the scripts are loaded, however it doesn't work, only Thread.sleep is working
    	 */
    	
//    	WebDriverWait wait = new WebDriverWait(driver, 5);
//    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));
//    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("script")));
    	
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(buttonLocator).click();
    }

    public String getAjaxData(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(contentLocator));

        return driver.findElement(contentLocator).getText();
    }

}
