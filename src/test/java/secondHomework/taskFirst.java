package secondHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import java.util.List;

public class taskFirst extends testDriver{
    @Test
    public void test() {
        SoftAssert softAss = new SoftAssert();

        //5. Assert that there are 4 items on the header..
        List<WebElement> itemsHead = wDrive.findElements(By.xpath("//nav/ul[1]/li"));
        int itemsHeadExp = 4;
        //..section are displayed..
        softAss.assertEquals(itemsHead.size(), itemsHeadExp);
        for (WebElement i : itemsHead) {
            softAss.assertTrue(i.isDisplayed());
        }
        //..and they have proper texts
        String[] expTexts = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for (int i = 0; i < expTexts.length; i++) {
            softAss.assertEquals(itemsHead.get(i).getText(), expTexts[i]);
        }

        //6. Assert that there are 4 images on the Index Page..
        List<WebElement> indexPageImages = wDrive.findElements(By.className("benefit-icon"));
        int expNumberOfImages = 4;
        softAss.assertEquals(indexPageImages.size(), expNumberOfImages);
        //..and they are displayed
        for (WebElement i : indexPageImages) {
            softAss.assertTrue(i.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page
        List<WebElement> indexPageTexts = wDrive.findElements(By.className("benefit-txt"));
        int expNumberOfTexts = 4;
        softAss.assertEquals(indexPageTexts.size(), expNumberOfTexts);
        String[] expPageTexts = {
                "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                "To be flexible and\n" + "customizable",
                "To be multiplatform",
                "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"
        };
        //Page under icons and they have proper text
        for (int i = 0; i < expPageTexts.length; i++) {
            softAss.assertEquals(indexPageTexts.get(i).getText(), expPageTexts[i]);
        }

        //8. Assert that there is the iframe with “Frame Button” exist
        softAss.assertEquals(wDrive.findElement(By.tagName("iframe")).getAttribute("src"), "https://jdi-testing.github.io/jdi-light/frame-button.html");

        //9. Switch to the iframe
        String iframeId = "frame";
        wDrive.switchTo().frame(iframeId);
        // and check that there is “Frame Button” in the iframe
        String expectedButtonText = "Frame Button";
        softAss.assertEquals(wDrive.findElement(By.id("frame-button")).getAttribute("value"), expectedButtonText);

        //10. Switch to original window back
        wDrive.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed
        List<WebElement> leftSectionItems = wDrive.findElements(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li"));
        int expectedSectionItems = 5;
        softAss.assertEquals(leftSectionItems.size(), expectedSectionItems);
        for (WebElement i : leftSectionItems) {
            softAss.assertTrue(i.isDisplayed());
        }
        // and they have proper text
        String[] expectedLeftSectionText = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        for (int i = 0; i < expectedLeftSectionText.length; i++) {
            softAss.assertEquals(leftSectionItems.get(i).getText(), expectedLeftSectionText[i]);
        }

        softAss.assertAll();
    }
}
