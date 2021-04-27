package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/22/2021
 */
public class ProgressBarPage {
    private final WebDriver driver;
    private final By startButtonLocator = By.id("startButton");
    private final By stopButtonLocator = By.id("stopButton");
    private final By progressBarLocator = By.id("progressBar");
    private final By jQueryLocator = By.cssSelector("script[src='https://code.jquery.com/jquery-3.2.1.min.js']");

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickStartButton(){
    	
        driver.findElement(startButtonLocator).click();
    }

    private void clickStopButton(){
        driver.findElement(stopButtonLocator).click();
    }

    /**
     *
     * @param percentage the percentage in numeric format. Ex. 75
     * @return
     */
    public String getProgressAtPercentage(String percentage){
        WebElement progressBar = driver.findElement(progressBarLocator);

        /*
    	 * I try to wait until the element I am interacting with appears, or
    	 * until the scripts are loaded, however it doesn't work, only Thread.sleep is working
    	 */
        
//      WebDriverWait wait1 = new WebDriverWait(driver, 2);
//    	
//    	wait1.until(ExpectedConditions.presenceOfElementLocated(jQueryLocator));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        clickStartButton();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.textToBePresentInElement(progressBar, percentage));
        clickStopButton();
        return driver.findElement(progressBarLocator).getText();
    }
}
