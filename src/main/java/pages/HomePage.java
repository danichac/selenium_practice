package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/22/2021
 */
public class HomePage {
    private final WebDriver driver;
    private By linkLocator;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AjaxPage clickAjax(){
        linkLocator = By.linkText("AJAX Data");
        driver.findElement(linkLocator).click();
        return new AjaxPage(driver);
    }

    public ProgressBarPage clickProgressBarPage(){
        linkLocator = By.linkText("Progress Bar");
        driver.findElement(linkLocator).click();
        return new ProgressBarPage(driver);
    }

    public MouseOverPage clickMouseOverPage(){
        linkLocator = By.linkText("Mouse Over");
        driver.findElement(linkLocator).click();
        return new MouseOverPage(driver);
    }

    public TextInputPage clickInputPage(){
        linkLocator = By.linkText("Text Input");
        driver.findElement(linkLocator).click();
        return new TextInputPage(driver);
    }

    public LoginPage clickLoginPage(){
        linkLocator = By.linkText("Sample App");
        driver.findElement(linkLocator).click();
        return new LoginPage(driver);
    }
}
