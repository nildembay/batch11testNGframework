package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class D14_KeyBoardActions1 extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.amazon.com/");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.click(searchBox).perform();
        actions.sendKeys("samsung").perform();
        actions.keyDown(Keys.SHIFT).perform();
        actions.sendKeys("a").perform();
        actions.keyUp(Keys.SHIFT).perform();
        actions.sendKeys("71").perform();
        actions.sendKeys(Keys.ENTER).perform();


    }
    @Test
    public void test2(){
        driver.get("https://www.amazon.com/");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions .click(searchBox)
                .sendKeys("samsung")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER).perform();

    }
}
