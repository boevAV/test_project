package thirdHomework;

import thirdHomework.expData.expData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class taskFirst extends testDriver{
    @Test
    public void testTask1() {
        SoftAssert softAssert = new SoftAssert();

        // 2. Assert browser title
        softAssert.assertEquals(hPage.getTitle(), expData.SITE_NAME);

        // 4. Assert Username is loggined
        softAssert.assertEquals(hPage.getLoggedName(), expData.LOGGED_USER_NAME);

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        softAssert.assertEquals(hPage.getHeaderSection().getItemsSize(), expData.HEADER_SECTION_ITEMS_SIZE);
        softAssert.assertEquals(hPage.getHeaderSection().getItemsNames(), expData.HEADER_SECTION_ITEMS_NAMES);

        hPage.getHeaderSection().getItems().forEach(item -> {
            softAssert.assertTrue(item.isDisplayed());
        });

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        softAssert.assertEquals(hPage.getBenefitIconsSize(), expData.BENEFIT_ICONS_SIZE);

        hPage.getBenefitIcons().forEach(icon -> {
            softAssert.assertTrue(icon.isDisplayed());
        });

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        softAssert.assertEquals(hPage.getBenefitIconsTextsSize(), expData.BENEFIT_ICONS_TEXTS_SIZE);
        softAssert.assertEquals(hPage.getBenefitIconsTextsStrings(), expData.BENEFIT_ICONS_TEXTS_STRINGS);

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(hPage.getFrame().isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(hPage.getFrameButton().isDisplayed());

        // 10. Switch to original window back
        hPage.switchToOriginalWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        softAssert.assertEquals(hPage.getLeftSection().getItemsSize(), expData.LEFT_SECTION_ITEMS_SIZE);

        hPage.getLeftSection().getItems().forEach(item -> {
            softAssert.assertTrue(item.isDisplayed());
        });

        softAssert.assertEquals(hPage.getLeftSection().getItemsNames(), expData.LEFT_SECTION_ITEMS_NAMES);

        softAssert.assertAll();
    }
}
