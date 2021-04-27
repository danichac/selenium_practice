package PagesTests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
/**
 * @project Selenium_practice
 * @Author Daniel Chacon Navarro
 * On 4/22/2021
 */
public class ProgressBarPageTest extends ParentTest{

	/**
	 * This test intends to stop the progress bar when it reached 75%, however
	 * since the speed at which the progress bar progresses is random, it fails when the
	 * speed is too high.
	 */
    @Test
    public void stopAt75Test(){
        var progressBarPage = homePage.clickProgressBarPage();

        String actual = progressBarPage.getProgressAtPercentage("75%");

        assertEquals(actual, "75%");
    }
}
