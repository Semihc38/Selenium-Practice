package com.automation.tests.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement content = driver.findElement(By.id("content"));
        System.out.println(content.getText());

        driver.switchTo().parentFrame(); // go to the top frame
        driver.switchTo().frame("frame-right"); // switch to the right frame

        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());

        // to go to the bottom frame, you need to switch to the default content
        // because, top frame is sibling for bottom frame, but not a parent
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");

        System.out.println(driver.findElement(By.tagName("body")).getText());
        driver.quit();

    }
}
