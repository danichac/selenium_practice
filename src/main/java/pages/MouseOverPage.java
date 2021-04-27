package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/22/2021
 */
public class MouseOverPage {
    private final WebDriver driver;
    private final By unclickableLink = By.className("text-primary");
    private final By clickableLink = By.className("text-warning");
    private final By counterLocator = By.id("clickCount");

    public MouseOverPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTwice(){
        Actions actions = new Actions(driver);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement unclickable = driver.findElement(unclickableLink);

        actions.moveToElement(unclickable).perform();

        WebElement clickable = driver.findElement(clickableLink);
        wait.until(ExpectedConditions.visibilityOf(clickable));

        actions.click(clickable).perform();
        actions.click(clickable).perform();

    }

    public String getCount(){
        return driver.findElement(counterLocator).getText();
    }
}
