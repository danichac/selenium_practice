package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/22/2021
 */
public class TextInputPage {
    public final WebDriver driver;
    private final By inputLocator = By.id("newButtonName");
    private final By buttonLocator = By.id("updatingButton");
    private String newName;

    public TextInputPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setButtonName(String name){
    	
    	/*
    	 * I try to wait until the element I am interacting with appears, or
    	 * until the scripts are loaded, however it doesn't work, only Thread.sleep is working
    	 */
    	
//    	WebDriverWait wait = new WebDriverWait(driver, 5);
//    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("script")));
    	
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(inputLocator).sendKeys(name);
        newName = name;
    }

    public void clickButton(){
        driver.findElement(buttonLocator).click();
    }

    public String getButtonName(){
        var button = driver.findElement(buttonLocator);

        return button.getText();
    }
}
