package PagesTests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/22/2021
 */
public class TextInputPageTest extends ParentTest{

    @Test
    public void testButtonChangeName(){

        var textInputPage = homePage.clickInputPage();
        var newName = "Updated Name";

        textInputPage.setButtonName(newName);
        textInputPage.clickButton();

        var actual = textInputPage.getButtonName();

        assertEquals(actual, newName, "The button name was not updated.");

    }

}
