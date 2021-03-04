package com.academy.project;

import com.academy.core.test.BaseTest;
import com.academy.core.util.PropertyProvider;
import com.academy.project.model.Laptop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.academy.project.page.HomePage.startFromHome;

public class DemoTests extends BaseTest {
    private static final Logger LOG =  LoggerFactory.getLogger(DemoTests.class);

    @Test(dataProvider = "laptopsProvider")
    public void testCheckListLaptops(List<Laptop> laptopsExpected) {
        List<Laptop> laptopsActual = startFromHome(driver, baseUrl)
                .clickLaptopLink()
                .getLaptops();

        // assert laptopsActual = laptopsExpected
    }

    @DataProvider(name="laptopsProvider")
    public Object[][] laptopsProvider() {
        String path = PropertyProvider.get("laptops");
        List<Laptop> laptops = readLaptops(path);

        return new Object[][] {
                {laptops}
        };
    }

    private List<Laptop> readLaptops(String path) {
        String csvSplitter = ",";
        List<Laptop> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == '#') {
                    continue;
                }

                Laptop laptop = new Laptop();
                String[] row = line.split(csvSplitter);
                laptop.setName(row[0]);
                laptop.setPrice(Integer.parseInt(row[1]));
                result.add(laptop);
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        return result;

    }
}
