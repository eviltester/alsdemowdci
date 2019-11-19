package com.seleniumsimplified.webdriver.basics.manipulate;

import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.manager.TestEnvironment;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ManipulateExampleTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){

        driver = Driver.get();
        driver.get(TestEnvironment.getUrl("/styled/basic-html-form-test.html"));
        // old version
        //driver = Driver.get(TestEnvironment.getUrl("basic_html_form.html"));
    }

    @Test
    public void simpleInteraction(){
        WebElement checkBox1 = driver.findElement(
                By.cssSelector("input[value='cb1']"));

        assertFalse("Starts not selected",
                checkBox1.isSelected());

        checkBox1.click();

        assertTrue("Click selects",
                checkBox1.isSelected());
    }

}
