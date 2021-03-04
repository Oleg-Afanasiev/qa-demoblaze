package com.academy.project.page;

import com.academy.core.page.BasePage;
import com.academy.project.model.Laptop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LaptopsPage extends BasePage {
    @FindBy(xpath = "//*[@id='tbodyid']/div/div/div/h4/a")
    private List<WebElement> namesLaptop;

    @FindBy(xpath = "//*[@id='tbodyid']/div/div/div/h5")
    private List<WebElement> prisesLaptop;

    public LaptopsPage(WebDriver driver) {
        super(driver);
    }

    private List<String> getNameLaptop() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < namesLaptop.size(); i++) {
            names.add(namesLaptop.get(i).getText());
        }
        return names;
    }

    private List<Integer> getPricesLaptop() {
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < prisesLaptop.size(); i++) {
            prices.add(Integer.parseInt(prisesLaptop.get(i).getText().replace("$", "")));
        }
        return prices;
    }

    public List<Laptop> getLaptops() {
        List<Laptop> laptops = new ArrayList<>();

        List<String> names = getNameLaptop();
        List<Integer> prices = getPricesLaptop();

        for (int i = 0; i < names.size(); i++) {
            laptops.add(new Laptop(names.get(i), prices.get(i)));
        }
        return laptops;
    }
}
