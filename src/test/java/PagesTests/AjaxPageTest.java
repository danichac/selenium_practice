package PagesTests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/22/2021
 */
public class AjaxPageTest extends ParentTest{

    @Test
    public void ajaxResponseTest(){
        var ajaxPage = homePage.clickAjax();
        ajaxPage.clickTriggerAjax();
        String response = ajaxPage.getAjaxData();

        assertEquals(response, "Data loaded with AJAX get request.", "Response is not correct");
    }
}
