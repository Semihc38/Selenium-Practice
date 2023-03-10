package com.automation.tests.selenium;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByIndex {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        BrowserUtils.wait(3);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        //index starts from 0
        stateSelect.selectByIndex(9);//District Of Columbia perhaps
        BrowserUtils.wait(3);


        List<WebElement> list = stateSelect.getOptions();
        System.out.println(list.size());

        //select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);


        BrowserUtils.wait(3);
        driver.quit();
    }
}
