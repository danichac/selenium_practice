package PagesTests;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/25/2021
 */
public class LoginPageTest extends ParentTest{
    private final String dataPath = "src/main/resources/data.ods";
    private String username;
    private String password;
    private String wrongPassword;
    private LoginPage loginPage;

    /**
     * This methods gets the data from the spreadsheet located at src/main/resources/data.ods
     */
    @BeforeClass
    public void setData(){
        File dataFile = new File(dataPath);
        loginPage = homePage.clickLoginPage();

        try {
            Sheet sheet = SpreadSheet.createFromFile(dataFile).getSheet(0);
            username = sheet.getCellAt("A3").getValue().toString();
            password = sheet.getCellAt("B3").getValue().toString();
            wrongPassword = sheet.getCellAt("B2").getValue().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginTest(){

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        String loginStatus = loginPage.getLoginStatusMessage();
        String expected = String.format("Welcome, %s!", username);

        assertEquals(loginStatus, expected, "Login failed.");
    }

    @Test
    public void wrongPasswordTest(){
        loginPage.reloadPage();
        loginPage.setUsername(username);
        loginPage.setPassword(wrongPassword);
        loginPage.clickLogin();

        String loginStatus = loginPage.getLoginStatusMessage();
        String expected = "Invalid username/password";

        assertEquals(loginStatus, expected, "Wrong password failed.");
    }
}
