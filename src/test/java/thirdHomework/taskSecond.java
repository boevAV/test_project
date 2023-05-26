package thirdHomework;

import thirdHomework.expData.expData;
import thirdHomework.pages.difElements.difElements;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class taskSecond extends testDriver{
    @Test
    public void testBrowserTitle() {
        // 2. Assert browser title
        assertEquals(hPage.getTitle(), expData.SITE_NAME);
    }

    @Test
    public void testLogin() {
        // 4. Assert Username is loggined
        assertEquals(hPage.getLoggedName(), expData.LOGGED_USER_NAME);
    }

    @Test
    public void testElements() {
        // 5. Open through the header menu Service -> Different Elements Page
        difElements difElementsPage = new difElements(driver, hPage);

        // 6. Select checkboxes
        difElementsPage.selectCheckbox("Water");
        difElementsPage.selectCheckbox("Wind");

        // 7. Select radio
        difElementsPage.selectRadio("Selen");

        // 8. Select in dropdown
        difElementsPage.selectDropdownOption("Yellow");

        // 9. Assert logs
        assertEquals(difElementsPage.getLogs(), expData.DIFFERENT_ELEMENTS_LOGS);
    }
}
