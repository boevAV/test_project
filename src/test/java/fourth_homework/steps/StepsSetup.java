package fourth_homework.steps;

import fourth_homework.pages.homePage.HomePage;
import fourth_homework.pages.differentElements.DifferentElements;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class StepsSetup {
    protected static WebDriver driver;
    protected static Properties properties;

    public static HomePage homePage;
    protected static DifferentElements differentElements;

    public StepsSetup(WebDriver driver, Properties properties) {
        StepsSetup.driver = driver;
        StepsSetup.properties = properties;
    }
}
