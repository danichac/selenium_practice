package PagesTests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/22/2021
 */
public class MouseOverPageTest extends ParentTest{

    @Test
    public void testClickTwice(){
        var mouseOverPage = homePage.clickMouseOverPage();
        mouseOverPage.clickTwice();
        String actual = mouseOverPage.getCount();

        assertEquals(actual, "2", "The number of clicks is incorrect");

    }

}
