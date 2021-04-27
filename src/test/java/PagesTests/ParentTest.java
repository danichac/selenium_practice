package PagesTests;

import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/21/2021
 */
public class ParentTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        goHome();

        homePage = new HomePage(driver);
    }

    @AfterClass
    public void endTest() {
        driver.quit();
    }

    public void goHome(){
        driver.get("http://www.uitestingplayground.com/");
        driver.manage().window().maximize();
    }

}
