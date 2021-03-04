package com.academy.project.page;

import com.academy.core.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//*[@id=\"itemc\"]")
    private WebElement laptopLink;

    public static  HomePage startFromHome(WebDriver driver, String baseUrl) {
        driver.get(baseUrl);
        return new HomePage(driver);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LaptopsPage clickLaptopLink() {
        laptopLink.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignore) {}
        return new LaptopsPage(driver);
    }
}
