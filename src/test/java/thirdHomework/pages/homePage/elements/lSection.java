package thirdHomework.pages.homePage.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class lSection {
    @FindBy(css = "#mCSB_1_container > ul > li")
    private List<WebElement> items;

    public lSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getItems() {
        return items;
    }

    public int getItemsSize() {
        return items.size();
    }

    public List<String> getItemsNames() {
        return items.stream().map(WebElement::getText).toList();
    }
}
