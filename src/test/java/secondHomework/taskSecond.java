package secondHomework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class taskSecond extends testDriver{
    @Test
    public void test() {
        SoftAssert softAss = new SoftAssert();

        //5. Open through the header menu Service -> Different Elements Page
        wDrive.findElement(By.className("dropdown-toggle")).click();
        wDrive.findElement(By.xpath("/html/body/header/div/nav/ul[1]/li[3]/ul/li[8]")).click();

        //6. Select checkboxes
        List<WebElement> checkboxes = wDrive.findElements(By.className("label-checkbox"));
        for (WebElement i : checkboxes) {
            if (i.getText().equals("Water") || i.getText().equals("Wind")) {
                i.click();
            }
        }

        //7. Select radio
        wDrive.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/label[4]"));

        //8. Select in dropdown
        wDrive.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/select/option[4]"));

        //9. Assert logs
        List<WebElement> actualLogs = wDrive.findElements(By.cssSelector("ul [class='panel-body-list logs'] > li"));

        String[] expLogs = {
                "Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };

        for (int i = 0; i < actualLogs.size(); i++) {
            softAss.assertEquals(actualLogs.get(i).getText().substring(9), expLogs[i]);
        }

        softAss.assertAll();
    }
}
