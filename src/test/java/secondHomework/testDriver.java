package secondHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class testDriver {
    public static WebDriver wDrive;

    @BeforeMethod
    public static void setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        wDrive = new ChromeDriver();
        wDrive.manage().window().maximize();

        SoftAssert softAssert = new SoftAssert();

        //1. Open test site by URL
        wDrive.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        String actUrl = wDrive.getCurrentUrl();
        String expUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        softAssert.assertEquals(actUrl, expUrl);

        //2. Assert Browser title
        String actTitle = wDrive.getTitle();
        String expTitle = "Home Page";
        softAssert.assertEquals(actTitle, expTitle);

        //3. Perform login
        wDrive.findElements(By.className("dropdown-toggle")).stream().skip(1).peek(WebElement::click).findFirst();
        wDrive.findElement(By.id("name")).sendKeys("Roman");
        wDrive.findElement(By.id("password")).sendKeys("Jdi1234");
        wDrive.findElement(By.id("login-button")).click();

        //4. Assert Username is logged
        String actualUsername = wDrive.findElement(By.id("user-name")).getText();
        String expectedUsername = "ROMAN IOVLEV";
        softAssert.assertEquals(actualUsername, expectedUsername);

        softAssert.assertAll();
    }

    //12. Close Browser
    @AfterTest
    public void tearDown() {
        wDrive.close();
    }
}
