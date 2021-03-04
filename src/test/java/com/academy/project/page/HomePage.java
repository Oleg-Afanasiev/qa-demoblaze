package com.academy.project.page;

import com.academy.core.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    @FindBy(xpath = "//*[contains(text(), 'Laptops')] ")
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
        //        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ignore) {}
        ExpectedCondition<Boolean> cond = ExpectedConditions.attributeContains(
                By.xpath("//*[@id='tbodyid']/div[1]/div/a/img") , "src", "imgs/sony_vaio_5.jpg"
        );
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(cond);

        return new LaptopsPage(driver);
    }
}
