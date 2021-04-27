package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/25/2021
 */
public class LoginPage {
    private final WebDriver driver;
    private final By usernameInputLocator = By.cssSelector("input[name='UserName']");
    private final By passwordInputLocator = By.cssSelector("input[name='Password']");
    private final By loginLocator = By.id("login");
    private final By loginStatusLocator = By.id("loginstatus");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username){
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
        driver.findElement(usernameInputLocator).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginLocator).click();
    }

    public String getLoginStatusMessage(){
        return driver.findElement(loginStatusLocator).getText();
    }

    public void reloadPage(){
        driver.navigate().refresh();
    }
}
