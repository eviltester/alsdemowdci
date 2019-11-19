package com.seleniumsimplified.webdriver.basics.interrogate.findby;

import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.manager.TestEnvironment;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FindElementsExampleTest {

    WebDriver driver;

    @Test
    public void returnAListOfElementsByClassName(){

        driver = Driver.get();
        driver.get(TestEnvironment.getUrl("/styled/find-by-playground-test.html"));
        // old version
        //driver = Driver.get(TestEnvironment.getUrl("find_by_playground.php"));

        List<WebElement> elements;
        elements = driver.findElements(
                              By.className("normal"));


        Set<String> foundTags = new HashSet<String>();

        for(WebElement e : elements){
            // added the toLowerCase because Opera used to return tags in uppercase
            foundTags.add(e.getTagName().toLowerCase());
        }

        assertTrue("expected p tag", foundTags.contains("p"));
        assertTrue("expected ul tag", foundTags.contains("ul"));
        assertTrue("expected li tag", foundTags.contains("li"));
        assertTrue("expected a tag", foundTags.contains("a"));
        assertFalse("did not expect div tag", foundTags.contains("div"));

        driver.close();
    }
}
